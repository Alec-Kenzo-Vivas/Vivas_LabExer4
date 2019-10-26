package com.example.vivas_labexer4;

import android.content.DialogInterface;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] CompName, CompCountry, CompIndustry, CompCeo, CompInfo;
    int[] CompanyLogo = {R.drawable.icbc
            ,R.drawable.jpmorganchase,R.drawable.chinaconstructionbank,
            R.drawable.agriculturalbankofchina,R.drawable.bankofamerica,R.drawable.apple,R.drawable.pingan,R.drawable.chinaconstructionbank,
            R.drawable.royaldutchshell,R.drawable.wellsfargo,R.drawable.exxonmobil,R.drawable.att,R.drawable.samsungelectronics,R.drawable.citigroup};
    ArrayList<CompanyDetail> companies= new ArrayList<>();
    ListView listCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CompName = getResources().getStringArray(R.array.CompName);
        CompCountry = getResources().getStringArray(R.array.CompCountry);
        CompIndustry = getResources().getStringArray(R.array.CompIndustry);
        CompCeo = getResources().getStringArray(R.array.CompCeo);
        CompInfo = getResources().getStringArray(R.array.CompInfo);

        for(int i = 0; i < CompName.length; i++){
            companies.add(new CompanyDetail(CompanyLogo[i], CompName[i], CompCountry[i], CompIndustry[i], CompCeo[i], CompInfo[i]));

        }

        CompanyAdapter adapter = new CompanyAdapter(this, R.layout.item, companies);

        listCompanies = findViewById(R.id.lvCompany);

        listCompanies.setAdapter(adapter);

        listCompanies.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(CompanyLogo[i]);
        dialog.setTitle(CompName[i]);
        dialog.setMessage(CompInfo[i]);
        dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, CompName[i], Toast.LENGTH_LONG).show();
            }
        });

        dialog.create().show();
    }
}
