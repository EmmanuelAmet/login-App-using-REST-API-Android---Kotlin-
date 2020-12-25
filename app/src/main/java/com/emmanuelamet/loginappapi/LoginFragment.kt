package com.emmanuelamet.loginappapi

import android.os.Bundle
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
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLogin.setOnClickListener{
            try{

            }catch (e:Exception){
                Toast.makeText(context, "Oops, something unexpected happened", Toast.LENGTH_LONG).show()
            }
        }

        lbl_create_account.setOnClickListener {
            Navigation.findNavController(it).navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment())
        }
    }

}