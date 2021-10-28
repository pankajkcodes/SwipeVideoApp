package com.simplifiededtech.swipevideoapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.simplifiededtech.swipevideoapp.R;
import com.simplifiededtech.swipevideoapp.adapters.VideoAdapter;
import com.simplifiededtech.swipevideoapp.model.VideoModel;
import com.simplifiededtech.swipevideoapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    ViewPager2 pager2;
    ArrayList<VideoModel> videos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        pager2 = root.findViewById(R.id.viewPager2);
        videos = new ArrayList<>();
        videos.add(new VideoModel("https://whatsapp-status-video.com/videos/sad-whatsapp-status-video-rula-ke-gaya-ishq-tera.mp4", "Sad Status", "Best Sad Status Of 2021"));
        videos.add(new VideoModel("https://whatsapp-status-video.com/videos/emiway-best-whatsapp-status-video.mp4", "Attitude", "Best Motivation"));
        videos.add(new VideoModel("https://whatsapp-status-video.com/videos/best-love-dialog-video-for-whatsapp-status.mp4", "", ""));
        videos.add(new VideoModel("https://whatsapp-status-video.com/videos/main-kisi-aur-ka-hun-filhaal-status-video.mp4", "", ""));
        videos.add(new VideoModel("https://whatsapp-status-video.com/videos/atif-aslam-best-song-for-love-status-video.mp4", "", ""));
        videos.add(new VideoModel("https://whatsapp-status-video.com/videos/lagdi-lahore-di-street-dancer-movie-song-status-video.mp4", "", ""));
        videos.add(new VideoModel("https://whatsapp-status-video.com/videos/ye-bhi-jaane-whatsapp-status-video.mp4", "", ""));
        videos.add(new VideoModel("https://whatsapp-status-video.com/videos/ijazat-status-video-for-whatsapp.mp4", "", ""));
        videos.add(new VideoModel("https://whatsapp-status-video.com/videos/aditya-rao-kapoor-movie-malang-2020-song-video-status.mp4", "", ""));
        pager2.setAdapter(new VideoAdapter(videos));


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}