package com.example.car.Screen_Fragment;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.car.Adapter.SelectImageAdapter;
import com.example.car.R;
import com.example.car.databinding.FragmentAddPostBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddPostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddPostFragment extends Fragment implements View.OnClickListener{

    FragmentAddPostBinding binding;
    ArrayList<Uri> list;
    SelectImageAdapter adaptor;
    String colum[] = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddPostFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddPostFragment newInstance(String param1, String param2) {
        AddPostFragment fragment = new AddPostFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddPostBinding.inflate(inflater);
        list = new ArrayList<>();
        adaptor = new SelectImageAdapter(list);
        binding.rcHomeFragment.setAdapter(adaptor);
        binding.buttonGellary.setOnClickListener(this);
        if ((ActivityCompat.checkSelfPermission(
                getActivity(), colum[0]) != PackageManager.PERMISSION_GRANTED) &&
                (ActivityCompat.checkSelfPermission(
                        getActivity(), colum[1]) != PackageManager.PERMISSION_GRANTED)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(colum, 123);
            }
        }
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonGellary:
                openGalley();
                break;
        }

    }

    private void openGalley() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Selcet Picture"), 123);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123 && resultCode == RESULT_OK) {
            if (data.getClipData() != null) {
                int x = data.getClipData().getItemCount();
                for (int i = 0; i < x; i++) {
                    list.add(data.getClipData().getItemAt(i).getUri());
                }
                adaptor.notifyDataSetChanged();
                binding.tvCountImage.setText(list.size()+"/"+binding.rcHomeFragment.getAdapter().getItemCount());
            } else if (data.getData() != null) {
                String imgurl = data.getData().getPath();
                list.add(Uri.parse(imgurl));
            }
        }
    }
}