package com.thinkaurelius.titan.diskstorage.util;

import com.thinkaurelius.titan.diskstorage.PermanentStorageException;
import com.thinkaurelius.titan.diskstorage.StorageException;

import java.io.File;

/**
 * (c) Matthias Broecheler (me@matthiasb.com)
 */

public class DirectoryUtil {


    public static File getOrCreateDataDirectory(String location) throws StorageException {
        File storageDir = new File(location);

        if (storageDir.exists() && storageDir.isFile())
            throw new PermanentStorageException(String.format("%s exists but is a file.", location));

        if (!storageDir.exists() && !storageDir.mkdirs())
            throw new PermanentStorageException(String.format("Failed to create directory %s for BerkleyDB storage.", location));

        return storageDir;
    }

}
