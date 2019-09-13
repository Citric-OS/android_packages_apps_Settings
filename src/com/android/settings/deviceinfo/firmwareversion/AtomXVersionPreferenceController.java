/*
**
** Copyright (C) 2022 Paranoid Android
** Copyright (C) 2022 The AtomX Project
**
** SPDX-License-Identifier: Apache-2.0
**
*/

package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

public class AtomXVersionPreferenceController extends BasePreferenceController {

    private static final String ATOMX_BUILD_VARIANT = "ro.atomx.build.variant";
    private static final String ATOMX_CODENAME = "ro.atomx.codename";
    private static final String ATOMX_MAJOR_VERSION = "ro.atomx.version.major";

    private final Context mContext;

    public AtomXVersionPreferenceController(Context context, String key) {
        super(context, key);
        mContext = context;
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE_UNSEARCHABLE;
    }

    @Override
    public CharSequence getSummary() {
        String atomxCodename = SystemProperties.get(ATOMX_CODENAME,
                mContext.getResources().getString(R.string.device_info_default));
        String atomxMajorVersion = SystemProperties.get(ATOMX_MAJOR_VERSION,
                mContext.getResources().getString(R.string.device_info_default));
        String atomxBuildVariant = SystemProperties.get(ATOMX_BUILD_VARIANT,
                mContext.getResources().getString(R.string.device_info_default));

        if (atomxBuildVariant.equals("Stable")) {
            return atomxCodename + " " + atomxBuildVariant;
        } else if (atomxBuildVariant.matches("Alpha|Beta")) {
           return atomxCodename + " " + atomxBuildVariant + " " + atomxMajorVersion;
        }
        return atomxCodename + " " + atomxMajorVersion + " " + atomxBuildVariant;
    }
}
