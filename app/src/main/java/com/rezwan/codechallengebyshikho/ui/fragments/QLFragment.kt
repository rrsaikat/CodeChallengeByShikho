package com.rezwan.codechallengebyshikho.ui.fragments


import android.widget.RadioGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.rezwan.codechallengebyshikho.R
import com.rezwan.codechallengebyshikho.databinding.FragmentQueryBinding
import com.rezwan.codechallengebyshikho.di.ViewModelFactory
import com.rezwan.codechallengebyshikho.ext.error
import com.rezwan.codechallengebyshikho.ext.hideKeyboard
import com.rezwan.codechallengebyshikho.ext.showShortToast
import com.rezwan.codechallengebyshikho.ui.base.BaseFragment
import com.rezwan.codechallengebyshikho.ui.viewmodel.SharedViewModel
import javax.inject.Inject

class QLFragment : BaseFragment<FragmentQueryBinding>(), RadioGroup.OnCheckedChangeListener {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel: SharedViewModel by viewModels { viewModelFactory }

    private var queryType: QueryType = QueryType.NONE

    override fun getLayoutRes(): Int = R.layout.fragment_query

    override fun setUpInitializers() {

    }

    override fun setUpListener() {
        binding.radioGroup.setOnCheckedChangeListener(this)
        binding.btnSubmit.setOnClickListener {
            hideKeyboard()
            runUserPrefferedQL()
        }
    }

    override fun setUpObservers() {
        viewModel.postByIdLivedata.observe(this, Observer {
            binding.tvQueryDetails.text = if (it == null) "No post info found" else
                    "ID: ${it.id} \n" + "Title: ${it.title}"
        })

        viewModel.userByIdLivedata.observe(this, Observer {
            binding.tvQueryDetails.text = if (it == null) "No user info found" else
                    "ID: ${it.id} \n" + "Username: ${it.username} \n" + "Email: ${it.email} \n" + "Geo: ${it.address?.geo?.lat} , ${it.address?.geo?.lng} \n"

        })

        viewModel.isLoading.observe(this, Observer { loadervalue ->
            binding.progressBar.isVisible = loadervalue
        })
    }

    override fun onCreate() {
        //AndroidSupportInjection.inject(this)
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        error(this, checkedId)
        queryType = getQLType(checkedId)

    }

    private fun runUserPrefferedQL() {
        if (queryType == QueryType.POST) {
            runPostQuery()
        } else if (queryType == QueryType.USER) {
            runUserQuery()
        } else {
            context?.showShortToast("Please select query type first")
        }
    }

    private fun runUserQuery() {
        with(binding.edtId){
            if (text.isNullOrEmpty())  setError("This field is required") else viewModel.getUser(text.toString())
        }
    }

    private fun runPostQuery() {
        with(binding.edtId){
            if (text.isNullOrEmpty())  setError("This field is required") else viewModel.getPost(text.toString())
        }
    }


    private fun getQLType(checkedId: Int): QueryType {
        when (checkedId) {
            R.id.radioBtn_user -> {
                return QueryType.USER
            }
            R.id.radioBtn_post -> {
                return QueryType.POST
            }
        }

        return QueryType.NONE
    }

    enum class QueryType { NONE, USER, POST }


}