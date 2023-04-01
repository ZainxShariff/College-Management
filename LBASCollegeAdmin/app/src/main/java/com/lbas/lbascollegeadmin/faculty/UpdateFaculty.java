package com.lbas.lbascollegeadmin.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lbas.lbascollegeadmin.R;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView principal,csDepartment,commerceDepartment,economicsDepartment,psDepartment,sociologyDepartment,historyDepartment,chemistryDepartment,bcDepartment,physicsDepartment,mathDepartment,botanyDepartment,zoologyDepartment,peDepartment,kannadaDepartment,englishDepartment,hindiDepartment,sanskritDepartment;
    private LinearLayout principalNoData,csNoData,commerceNoData,economicsNoData,psNoData,sociologyNoData,historyNoData,chemistryNoData,bcNoData,physicsNoData,mathNoData,botanyNoData,zoologyNoData,peNoData,kannadaNoData,englishNoData,hindiNoData,sanskritNoData;
    private List<TeacherData> principalList,csList,commerceList,economicsList,psList,sociologyList,historyList,chemistryList,bcList,physicsList,mathList,botanyList,zoologyList,peList,kannadaList,englishList,hindiList,sanskritList;
    private TeacherAdapter adapter;
    private DatabaseReference databaseReference,reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        fab = findViewById(R.id.fab);

        principal = findViewById(R.id.princpal);
        csDepartment = findViewById(R.id.csDepartment);
        commerceDepartment = findViewById(R.id.commerceDepartment);
        economicsDepartment = findViewById(R.id.economicsDepartment);
        psDepartment = findViewById(R.id.psDepartment);
        sociologyDepartment = findViewById(R.id.sociologyDepartment);
        historyDepartment = findViewById(R.id.historyDepartment);
        chemistryDepartment = findViewById(R.id.chemistryDepartment);
        bcDepartment = findViewById(R.id.bcDepartment);
        physicsDepartment = findViewById(R.id.physicsDepartment);
        mathDepartment = findViewById(R.id.mathDepartment);
        botanyDepartment = findViewById(R.id.botanyDepartment);
        zoologyDepartment = findViewById(R.id.zoologyDepartment);
        peDepartment = findViewById(R.id.peDepartment);
        kannadaDepartment = findViewById(R.id.kannadaDepartment);
        englishDepartment = findViewById(R.id.englishDepartment);
        hindiDepartment = findViewById(R.id.hindiDepartment);
        sanskritDepartment = findViewById(R.id.sanskritDepartment);

        principalNoData = findViewById(R.id.principalNoData);
        csNoData = findViewById(R.id.csNodata);
        commerceNoData = findViewById(R.id.commerceNodata);
        economicsNoData = findViewById(R.id.economicsNodata);
        psNoData = findViewById(R.id.psNodata);
        sociologyNoData = findViewById(R.id.sociologyNodata);
        historyNoData = findViewById(R.id.historyNodata);
        chemistryNoData = findViewById(R.id.chemistryNodata);
        bcNoData = findViewById(R.id.bcNodata);
        physicsNoData = findViewById(R.id.physicsNodata);
        mathNoData = findViewById(R.id.mathNodata);
        botanyNoData = findViewById(R.id.botanyNodata);
        zoologyNoData = findViewById(R.id.zoologyNodata);
        peNoData = findViewById(R.id.peNodata);
        kannadaNoData = findViewById(R.id.kannadaNodata);
        englishNoData = findViewById(R.id.englishNodata);
        hindiNoData = findViewById(R.id.hindiNodata);
        sanskritNoData = findViewById(R.id.sanskritNodata);

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

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateFaculty.this, AddTeacher.class));
            }
        });
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
                    principal.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(principalList,UpdateFaculty.this,"Principal");
                    principal.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    kannadaDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(kannadaList,UpdateFaculty.this,"Department of Kannada");
                    kannadaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    englishDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(englishList,UpdateFaculty.this,"Department of English");
                    englishDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    hindiDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(hindiList,UpdateFaculty.this,"Department of Hindi");
                    hindiDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    sanskritDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(sanskritList,UpdateFaculty.this,"Department of Sanskrit");
                    sanskritDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    csDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(csList,UpdateFaculty.this,"Department of Computer Science");
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    commerceDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(commerceList,UpdateFaculty.this,"Department of Commerce");
                    commerceDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    economicsDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(economicsList,UpdateFaculty.this,"Department of Economics");
                    economicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    psDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(psList,UpdateFaculty.this,"Department of Political Science");
                    psDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    sociologyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(sociologyList,UpdateFaculty.this,"Department of Sociology");
                    sociologyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    historyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(historyList,UpdateFaculty.this,"Department of History");
                    historyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    chemistryDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(chemistryList,UpdateFaculty.this,"Department of Chemistry");
                    chemistryDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    bcDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(bcList,UpdateFaculty.this,"Department of Biochemistry");
                    bcDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    physicsDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(physicsList,UpdateFaculty.this,"Department of Physics");
                    physicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    mathDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(mathList,UpdateFaculty.this,"Department of Mathematics");
                    mathDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    botanyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(botanyList,UpdateFaculty.this,"Department of Botany");
                    botanyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    zoologyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(zoologyList,UpdateFaculty.this,"Department of Zoology");
                    zoologyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    peDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(peList,UpdateFaculty.this,"Department of Physical Education");
                    peDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}