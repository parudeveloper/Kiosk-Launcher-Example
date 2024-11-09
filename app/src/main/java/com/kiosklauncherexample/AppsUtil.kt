package com.kiosklauncherexample

import android.content.Context
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

class AppsUtil {

    companion object {

        fun getAllApps(context: Context): List<AppInfo> {
            val packageManager: PackageManager = context.packageManager
            val appsList = ArrayList<AppInfo>()
            val i = Intent(Intent.ACTION_MAIN, null)
            i.addCategory(Intent.CATEGORY_LAUNCHER)
            val allApps = packageManager.queryIntentActivities(i, 0)
            for (ri in allApps) {
                val app = AppInfo(
                    ri.loadLabel(packageManager),
                    ri.activityInfo.packageName,
                    ri.activityInfo.loadIcon(packageManager)
                )
                appsList.add(app)
            }

            /* val i = Intent(Intent.ACTION_VIEW)  // Or your specific intent
             val allApps = packageManager.queryIntentActivities(i, 0)

 // List to store the filtered apps (only Chrome in this case)
             val appsList = mutableListOf<AppInfo>()

 // Define the package name for Chrome
             val chromePackage = "com.android.chrome"

             for (ri in allApps) {
                 // Load app name, package name, and icon
                 val appName = ri.loadLabel(packageManager).toString()
                 val appPackage = ri.activityInfo.packageName
                 val appIcon = ri.activityInfo.loadIcon(packageManager)

                 // Check if the app is Chrome
                 if (appPackage == chromePackage) {
                     // Add Chrome app to the list
                     val app = AppInfo(appName, appPackage, appIcon)
                     appsList.add(app)
                 }
             }*/

            /*
            *
            * val chromePackages = listOf(
                "com.android.chrome",               // Standard Chrome package
                "com.google.android.chrome",        // Another common Chrome variant
                "com.chrome",                       // Potential variant (less common)
            )

            for (ri in allApps) {
                val appPackage = ri.activityInfo.packageName
                if (chromePackages.contains(appPackage)) {
                    val appName = ri.loadLabel(packageManager).toString()
                    val appIcon = ri.activityInfo.loadIcon(packageManager)
                    val app = AppInfo(appName, appPackage, appIcon)
                    appsList.add(app)
                }
            }*/


            return appsList
        }

    }
}