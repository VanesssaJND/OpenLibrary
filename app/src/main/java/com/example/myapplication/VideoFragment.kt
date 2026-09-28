package com.example.myapplication

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment

class VideoFragment : Fragment(R.layout.fragment_video) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val videoView = view.findViewById<VideoView>(R.id.videoView)

        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)

        videoView.setMediaController(mediaController)

        val paquete = requireActivity().packageName
        val uri = Uri.parse("android.resource://$paquete/${R.raw.video_prueba}")

        videoView.setVideoURI(uri)
        videoView.requestFocus()

        videoView.start()
    }
}