package com.amaze.filemanager.ui.icons;

import android.webkit.MimeTypeMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowMimeTypeMap;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class IconsTest {

    @Before
    public void setUp(){
        //By default Robolectric's MimeTypeMap is empty, we need to populate them
        ShadowMimeTypeMap mimeTypeMap = Shadows.shadowOf(MimeTypeMap.getSingleton());
        mimeTypeMap.addExtensionMimeTypMapping("zip", "application/zip");
        mimeTypeMap.addExtensionMimeTypMapping("rar", "application/x-rar-compressed");
        mimeTypeMap.addExtensionMimeTypMapping("tar", "application/x-tar");
    }

    @Test
    public void testReturnArchiveTypes(){
        assertEquals(Icons.COMPRESSED, Icons.getTypeOfFile("archive.zip", false));
        assertEquals(Icons.COMPRESSED, Icons.getTypeOfFile("archive.rar", false));
        assertEquals(Icons.COMPRESSED, Icons.getTypeOfFile("archive.tar", false));
        assertEquals(Icons.COMPRESSED, Icons.getTypeOfFile("archive.tar.gz", false));
        assertEquals(Icons.COMPRESSED, Icons.getTypeOfFile("archive.tar.lzma", false));
        assertEquals(Icons.COMPRESSED, Icons.getTypeOfFile("archive.tar.xz", false));
        assertEquals(Icons.COMPRESSED, Icons.getTypeOfFile("archive.tar.bz2", false));

    }
}
