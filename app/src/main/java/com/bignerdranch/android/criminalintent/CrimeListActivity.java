package com.bignerdranch.android.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by tj on 8/11/17.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() { //calls to subclas singlefragmentactivity and defines createFragment();
        return new CrimeListFragment();
    }
}
