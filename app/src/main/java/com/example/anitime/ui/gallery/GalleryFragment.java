package com.example.anitime.ui.gallery;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.anitime.R;
import com.example.anitime.databinding.FragmentYourProfileBinding;

public class GalleryFragment extends Fragment {

    private FragmentYourProfileBinding binding;

    private Button saveInfo;
    private Button editInfo;
    EditText etname,etbreed,etage,etgender, etweight, etOwner, etPhone;
    TextView dName, dBreed, dAge, dGender, dWeight, dOwner, dPhone;
    LinearLayout linL0, linL1, linL2, linL3, linL00;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentYourProfileBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        //View rootView = inflater.inflate(R.layout.fragment_your_profile, container, false);
        saveInfo = (Button) rootView.findViewById(R.id.ypButton);
        editInfo = (Button) rootView.findViewById(R.id.editButton);
        dName = (TextView) rootView.findViewById(R.id.disName);
        dBreed = (TextView) rootView.findViewById(R.id.disBreed);
        dAge = (TextView) rootView.findViewById(R.id.disAge);
        dGender = (TextView) rootView.findViewById(R.id.disGender);
        dWeight = (TextView) rootView.findViewById(R.id.disWeight);
        dOwner = (TextView) rootView.findViewById(R.id.disOwner);
        dPhone = (TextView) rootView.findViewById(R.id.disPhone);

        /*
        dName.setText("Name: " + etname.getText().toString());
        dBreed.setText("Breed: " + etbreed.getText().toString());
        dAge.setText("Age: "+ etage.getText().toString());
        dGender.setText("Gender: "+ etgender.getText().toString());
        dWeight.setText("Weight: "+ etweight.getText().toString());
        */

        editInfo.setVisibility(View.VISIBLE);
        saveInfo.setVisibility(View.GONE);
        linL00 = (LinearLayout) rootView.findViewById(R.id.ll00);
        linL3 = (LinearLayout) rootView.findViewById(R.id.ll3);

        linL00.setVisibility(View.GONE);

        saveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etname=(EditText) rootView.findViewById(R.id.editTextPetName);
                etbreed=(EditText) rootView.findViewById(R.id.editTextTextPetBreed);
                etage=(EditText) rootView.findViewById(R.id.editTextTextPetAge);
                etgender=(EditText) rootView.findViewById(R.id.editTextTextPetGender);
                etweight=(EditText) rootView.findViewById(R.id.editTextTextPetWeight);
                etOwner=(EditText) rootView.findViewById(R.id.editTextOwner);
                etPhone=(EditText) rootView.findViewById(R.id.editTextPhone);

                //+"\nBreed: "+etbreed.getText().toString()+"\nAge: "+etage.getText().toString()
                // +"\nGender: "+etgender.getText().toString()
                //  +"\nWeight: "+etweight.getText().toString());

                dName.setText(etname.getText().toString());
                dBreed.setText(etbreed.getText().toString());
                dAge.setText(etage.getText().toString());
                dGender.setText(etgender.getText().toString());
                dWeight.setText(etweight.getText().toString());
                dOwner.setText(etOwner.getText().toString());
                dPhone.setText(etPhone.getText().toString());

                linL3.setVisibility(View.VISIBLE);
                linL00.setVisibility(View.GONE);

                saveInfo.setVisibility(View.GONE);
                editInfo.setVisibility(View.VISIBLE);

            }
        });

        editInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInfo.setVisibility(View.VISIBLE);
                editInfo.setVisibility(View.GONE);

                linL00.setVisibility(View.VISIBLE);
                linL3.setVisibility(View.GONE);
            }
        });

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
