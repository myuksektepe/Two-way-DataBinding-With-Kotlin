class CustomFragment : Fragment() {

    private var binding: FragmentCustomBinding? = null
    private val vm = CustomViewModel()
    private val lifeCycleOwner: LifecycleOwner = this@CustomFragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentCustomBinding>(inflater, R.layout.fragment_custom, container, false).apply {
            lifecycleOwner = lifeCycleOwner

            // this is require for Two-Way DataBinding
            viewModel = vm
        }
        
        observeViewModel()

        return binding?.root
    }

    private fun observeViewModel() {
        vm.counterLiveData.observe(lifeCycleOwner) { counter ->
            Log.i(TAG, "counter: $counter")
            counter?.let {
                binding?.txtCounter?.text = "$it"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
