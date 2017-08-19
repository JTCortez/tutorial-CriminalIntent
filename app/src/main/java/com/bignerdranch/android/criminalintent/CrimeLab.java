package com.bignerdranch.android.criminalintent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bignerdranch.android.criminalintent.database.CrimeBaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by tj on 8/11/17.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab; // 's' prefix is for static variable

    private List<Crime> mCrimes; // list to hold crimes
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab (Context context) { //since this is private no other class can create a crimelab
        mContext = context.getApplicationContext();
        mDatabase = new CrimeBaseHelper(mContext).getWritableDatabase();
        mCrimes = new ArrayList<>();

        //use to create 100 crimes for tutorial
        //generating 100 crimes
        //for (int i = 0; i < 100; i++) {
          //  Crime crime = new Crime();
            //crime.setTitle("Crime #" + i);
            //crime.setSolved(i % 2 == 0); // every other one
            //mCrimes.add(crime);
        //}
    }

    public void addCrime (Crime c) {
        mCrimes.add(c);
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime (UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}
