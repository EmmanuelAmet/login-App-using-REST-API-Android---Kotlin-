package com.emmanuelamet.loginappapi

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.emmanuelamet.loginappapi.model.User
import com.emmanuelamet.loginappapi.repository.Repository
import com.emmanuelamet.loginappapi.viewModel.UserViewModel
import com.emmanuelamet.loginappapi.viewModelFactory.UserViewModelFactory
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : Fragment() {

    companion object{
        private lateinit var userViewModel: UserViewModel
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_create_account.setOnClickListener {
            try{
                val name = name_sign_up.text.toString().trim()
                val email = email_sign_up.text.toString().trim()
                val password = password_sign_up.text.toString().trim()
                val confirmPassword = confirm_password_sign_up.text.toString().trim()

                ValidateCreateUserAccount(name, email, password, confirmPassword, btn_create_account)
            }catch (e:Exception){
                errorMessage()
            }
        }

        back_to_login.setOnClickListener {
            Navigation.findNavController(it).navigate(SignUpFragmentDirections.actionSignUpFragmentToLoginFragment())
        }
    }

    private fun errorMessage(){
        Toast.makeText(context, "Oops, something unexpected happened", Toast.LENGTH_LONG).show()
    }

    private fun ValidateCreateUserAccount(name:String, email:String, password:String, confirmPassword:String, view:View){
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)
            || TextUtils.isEmpty(confirmPassword)){
            Toast.makeText(context, "All field required.", Toast.LENGTH_LONG).show()

        }else if(password != confirmPassword){
            Toast.makeText(context, "Password do not match", Toast.LENGTH_LONG).show()
        }else{
            createAccount(name, email, password, view)
        }
    }

    private fun createAccount(name:String, email:String, password:String, view:View){
        try{
            val repository = Repository()
            val userViewModelFactory = UserViewModelFactory(repository)
            userViewModel = ViewModelProvider(this, userViewModelFactory).get(UserViewModel::class.java)
            val user = User(name, email, password)
            userViewModel.signUp(user)
            userViewModel.userResponse.observe(this, Observer { response->
                if(response.isSuccessful){
                    Navigation.findNavController(view).navigate(SignUpFragmentDirections.actionSignUpFragmentToLoginFragment())

                    Log.d("Response", response.code().toString())
                    Log.d("Response", "Account Created")
                    Toast.makeText(context, "Account Created Successfully.", Toast.LENGTH_LONG).show()
                    //Toast.makeText(context, response.code(), Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context, response.code(), Toast.LENGTH_LONG).show()
                    Log.d("Response", "Account Failed to Create.")
                }
            })
        }catch (e:Exception){
            Toast.makeText(context, "Oops, something unexpected", Toast.LENGTH_LONG).show()
        }
    }

}