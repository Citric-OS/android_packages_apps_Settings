/*
**
** Copyright (C) 2021 LineageOS
**
** SPDX-License-Identifier: Apache-2.0
**
*/

package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class RomBuildDatePreferenceController extends BasePreferenceController {

    private static final String TAG = "RomBuildDateCtrl";

    private static final String KEY_BUILD_DATE_PROP = "ro.build.date";

    public RomBuildDatePreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        return SystemProperties.get(KEY_BUILD_DATE_PROP,
                mContext.getString(R.string.unknown));
    }
}
