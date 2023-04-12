package com.syoon.mediasearchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.syoon.mediasearchapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    // fragment는 activity와 다르게 onDestroyed될 때 binding객체를 해제해야 하므로
    // nullable로 선언
    private var binding : FragmentSearchBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentSearchBinding.inflate(inflater, container, false).apply {
            binding = this // binding 초기화
        }.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}