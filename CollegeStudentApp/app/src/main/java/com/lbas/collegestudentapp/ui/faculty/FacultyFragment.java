package com.lbas.collegestudentapp.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lbas.collegestudentapp.R;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {

    private RecyclerView principal,csDepartment,commerceDepartment,economicsDepartment,psDepartment,sociologyDepartment,historyDepartment,chemistryDepartment,bcDepartment,physicsDepartment,mathDepartment,botanyDepartment,zoologyDepartment,peDepartment,kannadaDepartment,englishDepartment,hindiDepartment,sanskritDepartment;
    private LinearLayout principalNoData,csNoData,commerceNoData,economicsNoData,psNoData,sociologyNoData,historyNoData,chemistryNoData,bcNoData,physicsNoData,mathNoData,botanyNoData,zoologyNoData,peNoData,kannadaNoData,englishNoData,hindiNoData,sanskritNoData;
    private List<TeacherData> principalList,csList,commerceList,economicsList,psList,sociologyList,historyList,chemistryList,bcList,physicsList,mathList,botanyList,zoologyList,peList,kannadaList,englishList,hindiList,sanskritList;
    private TeacherAdapter adapter;
    private DatabaseReference databaseReference,reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        principal = view.findViewById(R.id.princpal);
        csDepartment = view.findViewById(R.id.csDepartment);
        commerceDepartment = view.findViewById(R.id.commerceDepartment);
        economicsDepartment = view.findViewById(R.id.economicsDepartment);
        psDepartment = view.findViewById(R.id.psDepartment);
        sociologyDepartment = view.findViewById(R.id.sociologyDepartment);
        historyDepartment = view.findViewById(R.id.historyDepartment);
        chemistryDepartment = view.findViewById(R.id.chemistryDepartment);
        bcDepartment = view.findViewById(R.id.bcDepartment);
        physicsDepartment = view.findViewById(R.id.physicsDepartment);
        mathDepartment = view.findViewById(R.id.mathDepartment);
        botanyDepartment = view.findViewById(R.id.botanyDepartment);
        zoologyDepartment = view.findViewById(R.id.zoologyDepartment);
        peDepartment = view.findViewById(R.id.peDepartment);
        kannadaDepartment = view.findViewById(R.id.kannadaDepartment);
        englishDepartment = view.findViewById(R.id.englishDepartment);
        hindiDepartment = view.findViewById(R.id.hindiDepartment);
        sanskritDepartment = view.findViewById(R.id.sanskritDepartment);

        principalNoData = view.findViewById(R.id.principalNoData);
        csNoData = view.findViewById(R.id.csNodata);
        commerceNoData = view.findViewById(R.id.commerceNodata);
        economicsNoData = view.findViewById(R.id.economicsNodata);
        psNoData = view.findViewById(R.id.psNodata);
        sociologyNoData = view.findViewById(R.id.sociologyNodata);
        historyNoData = view.findViewById(R.id.historyNodata);
        chemistryNoData = view.findViewById(R.id.chemistryNodata);
        bcNoData = view.findViewById(R.id.bcNodata);
        physicsNoData = view.findViewById(R.id.physicsNodata);
        mathNoData = view.findViewById(R.id.mathNodata);
        botanyNoData = view.findViewById(R.id.botanyNodata);
        zoologyNoData = view.findViewById(R.id.zoologyNodata);
        peNoData = view.findViewById(R.id.peNodata);
        kannadaNoData = view.findViewById(R.id.kannadaNodata);
        englishNoData = view.findViewById(R.id.englishNodata);
        hindiNoData = view.findViewById(R.id.hindiNodata);
        sanskritNoData = view.findViewById(R.id.sanskritNodata);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Teachers");

        principal();
        kannadaDepartment();
        englishDepartment();
        hindiDepartment();
        sanskritDepartment();
        csDepartment();
        commerceDepartment();
        economicsDepartment();
        psDepartment();
        sociologyDepartment();
        historyDepartment();
        chemistryDepartment();
        bcDepartment();
        physicsDepartment();
        mathDepartment();
        botanyDepartment();
        zoologyDepartment();
        peDepartment();

        return view;
    }

    private void principal() {
        reference = databaseReference.child("Principal");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                principalList = new ArrayList<>();
                if(!snapshot.exists()){
                    principalNoData.setVisibility(View.VISIBLE);
                    principal.setVisibility(View.GONE);
                }
                else{
                    principalNoData.setVisibility(View.GONE);
                    principal.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        principalList.add(data);
                    }
                    principal.setHasFixedSize(true);
                    principal.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(principalList,getContext());
                    principal.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void kannadaDepartment() {
        reference = databaseReference.child("Department of Kannada");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                kannadaList = new ArrayList<>();
                if(!snapshot.exists()){
                    kannadaNoData.setVisibility(View.VISIBLE);
                    kannadaDepartment.setVisibility(View.GONE);
                }
                else{
                    kannadaNoData.setVisibility(View.GONE);
                    kannadaDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        kannadaList.add(data);
                    }
                    kannadaDepartment.setHasFixedSize(true);
                    kannadaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(kannadaList,getContext());
                    kannadaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void englishDepartment() {
        reference = databaseReference.child("Department of English");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                englishList = new ArrayList<>();
                if(!snapshot.exists()){
                    englishNoData.setVisibility(View.VISIBLE);
                    englishDepartment.setVisibility(View.GONE);
                }
                else{
                    englishNoData.setVisibility(View.GONE);
                    englishDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        englishList.add(data);
                    }
                    englishDepartment.setHasFixedSize(true);
                    englishDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(englishList,getContext());
                    englishDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void hindiDepartment() {
        reference = databaseReference.child("Department of Hindi");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                hindiList = new ArrayList<>();
                if(!snapshot.exists()){
                    hindiNoData.setVisibility(View.VISIBLE);
                    hindiDepartment.setVisibility(View.GONE);
                }
                else{
                    hindiNoData.setVisibility(View.GONE);
                    hindiDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        hindiList.add(data);
                    }
                    hindiDepartment.setHasFixedSize(true);
                    hindiDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(hindiList,getContext());
                    hindiDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sanskritDepartment() {
        reference = databaseReference.child("Department of Sanskrit");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                sanskritList = new ArrayList<>();
                if(!snapshot.exists()){
                    sanskritNoData.setVisibility(View.VISIBLE);
                    sanskritDepartment.setVisibility(View.GONE);
                }
                else{
                    sanskritNoData.setVisibility(View.GONE);
                    sanskritDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        sanskritList.add(data);
                    }
                    sanskritDepartment.setHasFixedSize(true);
                    sanskritDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(sanskritList,getContext());
                    sanskritDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void csDepartment() {
        reference = databaseReference.child("Department of Computer Science");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                csList = new ArrayList<>();
                if(!snapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }
                else{
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        csList.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(csList,getContext());
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void commerceDepartment() {
        reference = databaseReference.child("Department of Commerce");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                commerceList = new ArrayList<>();
                if(!snapshot.exists()){
                    commerceNoData.setVisibility(View.VISIBLE);
                    commerceDepartment.setVisibility(View.GONE);
                }
                else{
                    commerceNoData.setVisibility(View.GONE);
                    commerceDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        commerceList.add(data);
                    }
                    commerceDepartment.setHasFixedSize(true);
                    commerceDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(commerceList,getContext());
                    commerceDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void economicsDepartment() {
        reference = databaseReference.child("Department of Economics");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                economicsList = new ArrayList<>();
                if(!snapshot.exists()){
                    economicsNoData.setVisibility(View.VISIBLE);
                    economicsDepartment.setVisibility(View.GONE);
                }
                else{
                    economicsNoData.setVisibility(View.GONE);
                    economicsDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        economicsList.add(data);
                    }
                    economicsDepartment.setHasFixedSize(true);
                    economicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(economicsList,getContext());
                    economicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void psDepartment() {
        reference = databaseReference.child("Department of Political Science");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                psList = new ArrayList<>();
                if(!snapshot.exists()){
                    psNoData.setVisibility(View.VISIBLE);
                    psDepartment.setVisibility(View.GONE);
                }
                else{
                    psNoData.setVisibility(View.GONE);
                    psDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        psList.add(data);
                    }
                    psDepartment.setHasFixedSize(true);
                    psDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(psList,getContext());
                    psDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sociologyDepartment() {
        reference = databaseReference.child("Department of Sociology");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                sociologyList = new ArrayList<>();
                if(!snapshot.exists()){
                    sociologyNoData.setVisibility(View.VISIBLE);
                    sociologyDepartment.setVisibility(View.GONE);
                }
                else{
                    sociologyNoData.setVisibility(View.GONE);
                    sociologyDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        sociologyList.add(data);
                    }
                    sociologyDepartment.setHasFixedSize(true);
                    sociologyDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(sociologyList,getContext());
                    sociologyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void historyDepartment() {
        reference = databaseReference.child("Department of History");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                historyList = new ArrayList<>();
                if(!snapshot.exists()){
                    historyNoData.setVisibility(View.VISIBLE);
                    historyDepartment.setVisibility(View.GONE);
                }
                else{
                    historyNoData.setVisibility(View.GONE);
                    historyDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        historyList.add(data);
                    }
                    historyDepartment.setHasFixedSize(true);
                    historyDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(historyList,getContext());
                    historyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void chemistryDepartment() {
        reference = databaseReference.child("Department of Chemistry");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                chemistryList = new ArrayList<>();
                if(!snapshot.exists()){
                    chemistryNoData.setVisibility(View.VISIBLE);
                    chemistryDepartment.setVisibility(View.GONE);
                }
                else{
                    chemistryNoData.setVisibility(View.GONE);
                    chemistryDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        chemistryList.add(data);
                    }
                    chemistryDepartment.setHasFixedSize(true);
                    chemistryDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(chemistryList,getContext());
                    chemistryDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bcDepartment() {
        reference = databaseReference.child("Department of Biochemistry");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                bcList = new ArrayList<>();
                if(!snapshot.exists()){
                    bcNoData.setVisibility(View.VISIBLE);
                    bcDepartment.setVisibility(View.GONE);
                }
                else{
                    bcNoData.setVisibility(View.GONE);
                    bcDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        bcList.add(data);
                    }
                    bcDepartment.setHasFixedSize(true);
                    bcDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(bcList,getContext());
                    bcDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void physicsDepartment() {
        reference = databaseReference.child("Department of Physics");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                physicsList = new ArrayList<>();
                if(!snapshot.exists()){
                    physicsNoData.setVisibility(View.VISIBLE);
                    physicsDepartment.setVisibility(View.GONE);
                }
                else{
                    physicsNoData.setVisibility(View.GONE);
                    physicsDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        physicsList.add(data);
                    }
                    physicsDepartment.setHasFixedSize(true);
                    physicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(physicsList,getContext());
                    physicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mathDepartment() {
        reference = databaseReference.child("Department of Mathematics");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mathList = new ArrayList<>();
                if(!snapshot.exists()){
                    mathNoData.setVisibility(View.VISIBLE);
                    mathDepartment.setVisibility(View.GONE);
                }
                else{
                    mathNoData.setVisibility(View.GONE);
                    mathDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        mathList.add(data);
                    }
                    mathDepartment.setHasFixedSize(true);
                    mathDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(mathList,getContext());
                    mathDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void botanyDepartment() {
        reference = databaseReference.child("Department of Botany");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                botanyList = new ArrayList<>();
                if(!snapshot.exists()){
                    botanyNoData.setVisibility(View.VISIBLE);
                    botanyDepartment.setVisibility(View.GONE);
                }
                else{
                    botanyNoData.setVisibility(View.GONE);
                    botanyDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        botanyList.add(data);
                    }
                    botanyDepartment.setHasFixedSize(true);
                    botanyDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(botanyList,getContext());
                    botanyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void zoologyDepartment() {
        reference = databaseReference.child("Department of Zoology");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                zoologyList = new ArrayList<>();
                if(!snapshot.exists()){
                    zoologyNoData.setVisibility(View.VISIBLE);
                    zoologyDepartment.setVisibility(View.GONE);
                }
                else{
                    zoologyNoData.setVisibility(View.GONE);
                    zoologyDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        zoologyList.add(data);
                    }
                    zoologyDepartment.setHasFixedSize(true);
                    zoologyDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(zoologyList,getContext());
                    zoologyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void peDepartment() {
        reference = databaseReference.child("Department of Physical Education");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                peList = new ArrayList<>();
                if(!snapshot.exists()){
                    peNoData.setVisibility(View.VISIBLE);
                    peDepartment.setVisibility(View.GONE);
                }
                else{
                    peNoData.setVisibility(View.GONE);
                    peDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        peList.add(data);
                    }
                    peDepartment.setHasFixedSize(true);
                    peDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(peList,getContext());
                    peDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}