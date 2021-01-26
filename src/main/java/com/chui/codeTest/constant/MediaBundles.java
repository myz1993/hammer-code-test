package com.chui.codeTest.constant;

import com.chui.codeTest.model.MediaTypes;
import com.chui.codeTest.model.SubmissionBundle;
import java.util.*;

public class MediaBundles {
  public final static Map<MediaTypes, List<SubmissionBundle>> BUNDLE_LIST = new HashMap<>();

  static {
    BUNDLE_LIST.put(MediaTypes.IMG, new ArrayList<>(Arrays.asList(
      SubmissionBundle.builder().bundleQuantity(5).pricePerBundle(450.0).build(),
      SubmissionBundle.builder().bundleQuantity(10).pricePerBundle(800.0).build()
    )));

    BUNDLE_LIST.put(MediaTypes.VID, new ArrayList<>(Arrays.asList(
      SubmissionBundle.builder().bundleQuantity(3).pricePerBundle(570.0).build(),
      SubmissionBundle.builder().bundleQuantity(5).pricePerBundle(900.0).build(),
      SubmissionBundle.builder().bundleQuantity(9).pricePerBundle(1530.0).build()
    )));

    BUNDLE_LIST.put(MediaTypes.FLAC, new ArrayList<>(Arrays.asList(
      SubmissionBundle.builder().bundleQuantity(3).pricePerBundle(427.5).build(),
      SubmissionBundle.builder().bundleQuantity(6).pricePerBundle(810).build(),
      SubmissionBundle.builder().bundleQuantity(9).pricePerBundle(1147.5).build()
    )));
  }
}
