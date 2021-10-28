package com.simplifiededtech.swipevideoapp.fragments;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.simplifiededtech.swipevideoapp.R;

import java.util.Objects;


public class AddFragment extends Fragment {

    private static final int CAMERA_PERMISSION_CODE = 100;
    private static Uri videoPath;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_add, container, false);

        Button recordBtn = root.findViewById(R.id.recordBtn);

        if (isCameraPresentInPhone()) {
            Log.d("TAG", "onCreateView:  Camera is detected");
            getCameraPermission();
        } else {

            Log.d("TAG", "onCreateView:  Camera is not detected");
        }

        recordBtn.setOnClickListener(v -> {

            recordVideo();

        });


        return root;
    }

    private boolean isCameraPresentInPhone() {

        return requireActivity().getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA_ANY);


    }

    private void getCameraPermission() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(requireActivity(),
                Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
            int CAMERA_PERMISSION_CODE = 100;
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);

        }
    }

    private void recordVideo() {
        resultLauncher.launch(new Intent(MediaStore.ACTION_VIDEO_CAPTURE));

    }

    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    assert result.getData() != null;
                    videoPath = result.getData().getData();
                    Log.d("TAG", "video path is: " + videoPath);
                }
            });


}