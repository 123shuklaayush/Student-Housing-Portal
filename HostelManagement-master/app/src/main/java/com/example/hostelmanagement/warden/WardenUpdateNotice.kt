package com.example.hostelmanagement.warden

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hostelmanagement.Adapters.NoticeAdapterWithDelete
import com.example.hostelmanagement.Adapters.NoticeDeleteAdapterClick
import com.example.hostelmanagement.R
import com.example.hostelmanagement.database.StudentNotice
import com.example.hostelmanagement.databinding.FragmentWardenUpdateNoticeBinding

@Suppress("DEPRECATION")
class WardenUpdateNotice : Fragment(), NoticeDeleteAdapterClick {
    lateinit var binding: FragmentWardenUpdateNoticeBinding
    lateinit var viewModel: WardenViewModel

    companion object {
        const val CAMERA_REQUEST = 1000
        const val PICK_IMAGE = 999
    }

    @Suppress("DEPRECATION")
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_warden_update_notice, container, false)

        binding.wardenREcyclerView.layoutManager = LinearLayoutManager(context)
        //setting up adapter
        val adapter = NoticeAdapterWithDelete(requireContext(), this)
        binding.wardenREcyclerView.adapter = adapter

        //initailizing viewmodel
        viewModel = WardenViewModel(requireNotNull(activity).application)

        viewModel.allNotice.observe(viewLifecycleOwner, { list ->
            list.let {
                adapter.submitList(it)
            }

        })

        //camera and galery internt
        binding.cameraButton.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, CAMERA_REQUEST)
        }


        return binding.root
    }

    override fun ondelteClick(notice: StudentNotice) {
        viewModel.deleteNotice(notice)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CAMERA_REQUEST) {
            val photo: Bitmap = data!!.extras!!.get("data") as Bitmap
            viewModel.insertNotice(StudentNotice(photo))
        }

    }
}