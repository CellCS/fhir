package org.hl7.fhir.definitions.generators.specification;

import org.hl7.fhir.instance.model.Resource;
import org.hl7.fhir.utilities.Utilities;

public class ToolResourceUtilities {

  public static final String NAME_SPEC_USAGE = "spec.usage";
  public static final String NAME_RES_IG = "spec.vs.ig";
  public static final String NAME_RES_PROFILE = "spec.res.profile";
  public static final String NAME_RES_RESOURCE = "spec.res.resoruce";
  
  public static final Object EXT_SPREADSHEET = "http://hl7.org/fhir/tools-spreadsheet";

  public static void updateUsage(Resource res, String usage) {
    if (Utilities.noString(usage))
      return;
    
    String s = (String) res.getUserData(NAME_SPEC_USAGE);
    if (Utilities.noString(s))
      s = usage;
    else if (!s.equals("core")) {
      if (usage.equals("core"))
        s = "core";
      else if (!s.contains(usage))
        s = s+","+usage;
    }
    res.setUserData(NAME_SPEC_USAGE, s);
  }

  public static String getUsage(Resource res) {
    return (String) res.getUserData(NAME_SPEC_USAGE);
  }
}
