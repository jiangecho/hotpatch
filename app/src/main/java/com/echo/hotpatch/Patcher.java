package com.echo.hotpatch;

import com.android.tools.fd.runtime.PatchesLoader;

/**
 * Created by jiangecho on 2016/9/23.
 */

// patch in a seperate thread
public class Patcher {
    public static void patch() {
        try {
            Class<?> aClass = Class.forName("com.android.tools.fd.runtime.AppPatchesLoaderImpl");
            PatchesLoader patchesLoader = (PatchesLoader) aClass.newInstance();
            patchesLoader.load();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
