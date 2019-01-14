package com.tools.deploy;

import java.io.File;

public class Const {

	public static String SRC_DIR = "/src";
	
	public static String DEPLOY_DIR = "/deploy";
	
	public static String CURRENT_PATH = new File("").getAbsolutePath();
	
	public static String DEPLOY_PATH = Const.CURRENT_PATH + Const.DEPLOY_DIR;
	
	public static String VERSION_API = "44.0";

	public static String MANIFEST_FILE = "/package.xml";

	public static String[][] META_NAME = new String[][] {{"ApexClass","classes"},{"ApexComponent",""}
		,{"ApexPage","pages"},{"ApexTrigger","triggers"},{"AppMenu","appMenus"},{"ApprovalProcess",""}
		,{"AuraDefinitionBundle","aura"},{"AuthProvider",""},{"CallCenter",""},{"Community","communities"}
		,{"ConnectedApp","connectedApps"},{"CustomApplication","applications"},{"CustomApplicationComponent",""}
		,{"CustomLabels","labels"},{"CustomMetadata",""},{"CustomObject","objects"},{"CustomObjectTranslation",""}
		,{"CustomPageWebLink",""},{"CustomPermission",""},{"CustomTab","tabs"},{"Dashboard","dashboards"}
		,{"DataCategoryGroup",""},{"Document","documents"},{"DuplicateRule","duplicateRules"}
		,{"FlexiPage","flexipages"},{"Flow","flows"},{"Group","groups"},{"HomePageComponent","homePageLayouts"}
		,{"HomePageLayout",""},{"Layout", "layouts"},{"Letterhead",""},{"MatchingRules","matchingRules"}
		,{"PermissionSet","permissionsets"},{"PostTemplate",""},{"Profile","profiles"},{"Queue",""}
		,{"QuickAction","quickActions"},{"Report","reports"},{"ReportType","reportTypes"},{"Role","roles"}
		,{"Scontrol",""},{"SharingRules","sharingRules"},{"SiteDotCom",""},{"StaticResource","staticresources"}
		,{"Workflow","workflows"}, {"Settings","settings"}};

	
	public static String[] META_NAME_APEX_CLASS = new String[] {"ApexClass","classes"};
	
	public static String[] META_NAME_APEX_COMPONENT = new String[] {"ApexComponent",""};
	
	public static String[] META_NAME_APEX_PAGE = new String[] {"ApexPage","pages"};
	
	public static String[] META_NAME_APEX_TRIGGER = new String[] {"ApexTrigger","triggers"};
	
	public static String[] META_NAME_APP_MENU = new String[] {"AppMenu","appMenus"};
	
	public static String[] META_NAME_APPROVAL_PROCESS = new String[] {"ApprovalProcess",""};
	
	public static String[] META_NAME_LIGHTNING_COMPONENT = new String[] {"AuraDefinitionBundle","aura"};
	
	public static String[] META_NAME_AUTH = new String[] {"AuthProvider",""};
	
	public static String[] META_NAME_CALL_CENTER = new String[] {"CallCenter",""};
	
	public static String[] META_NAME_COMMUNITY = new String[] {"Community","communities"};
	
	public static String[] META_NAME_CONNECTED_APP = new String[] {"ConnectedApp","connectedApps"};
	
	public static String[] META_NAME_CUSTOM_APPLICATION = new String[] {"CustomApplication","applications"};
	
	public static String[] META_NAME_CUSTOM_APPLICATION_COMPONENT = new String[] {"CustomApplicationComponent",""};
	
	public static String[] META_NAME_CUSTOM_LABELS = new String[] {"CustomLabels","labels"};
	
	public static String[] META_NAME_CUSTOM_METADATA = new String[] {"CustomMetadata",""};
	
	public static String[] META_NAME_CUSTOM_OBJECT = new String[] {"CustomObject","objects"};
	
	public static String[] META_NAME_CUSTOM_OBJECT_TRANSLATION = new String[] {"CustomObjectTranslation",""};
	
	public static String[] META_NAME_CUSTOM_PAGE_WEB_LINK = new String[] {"CustomPageWebLink",""};
	
	public static String[] META_NAME_CUSTOM_PERMISSION = new String[] {"CustomPermission",""};
	
	public static String[] META_NAME_CUSTOM_TAB = new String[] {"CustomTab","tabs"};
	
	public static String[] META_NAME_DASHBOARD = new String[] {"Dashboard","dashboards"};
	
	public static String[] META_NAME_DATA_CATEGORY_GROUP = new String[] {"DataCategoryGroup",""};
	
	public static String[] META_NAME_DOCUMENT = new String[] {"Document","documents"};
	
	public static String[] META_NAME_DUPLICATE_RULE = new String[] {"DuplicateRule","duplicateRules"};
	
	public static String[] META_NAME_FLEXI_PAGE = new String[] {"FlexiPage","flexipages"};
	
	public static String[] META_NAME_FLOW = new String[] {"Flow","flows"};
	
	public static String[] META_NAME_GROUP = new String[] {"Group","groups"};
	
	public static String[] META_NAME_HOME_PAGE_COMPONENT = new String[] {"HomePageComponent","homePageLayouts"};
	
	public static String[] META_NAME_HOME_PAGE_LAYOUT = new String[] {"HomePageLayout",""};
	
	public static String[] META_NAME_LAYOUT = new String[]{"Layout", "layouts"};
	
	public static String[] META_NAME_LETTERHEAD = new String[] {"Letterhead",""};
	
	public static String[] META_NAME_MATCHING_RULES = new String[] {"MatchingRules","matchingRules"};
	
	public static String[] META_NAME_PERMISSION_SET = new String[] {"PermissionSet","permissionsets"};
	
	public static String[] META_NAME_POST_TEMPLATE = new String[] {"PostTemplate",""};
	
	public static String[] META_NAME_PROFILE = new String[] {"Profile","profiles"};
	
	public static String[] META_NAME_QUEUE = new String[] {"Queue",""};
	
	public static String[] META_NAME_QUICK_ACTION = new String[] {"QuickAction","quickActions"};
	
	public static String[] META_NAME_REPORT = new String[] {"Report","reports"};
	
	public static String[] META_NAME_REPORT_TYPE = new String[] {"ReportType","reportTypes"};
	
	public static String[] META_NAME_ROLE = new String[] {"Role","roles"};
	
	public static String[] META_NAME_SCONTROL = new String[] {"Scontrol",""};
	
	public static String[] META_NAME_SHARING_RULES = new String[] {"SharingRules","sharingRules"};
	
	public static String[] META_NAME_SITE_DOT_COM = new String[] {"SiteDotCom",""};

	public static String[] META_NAME_STATICSOURCE = new String[] {"StaticResource","staticresources"};

	public static String[] META_NAME_WORKFLOW = new String[] {"Workflow","workflows"};
	
	public static String[] META_NAME_SETTINGS = new String[] {"Settings","settings"};
	
	public static String IGNORE_FILE_APEX = ".*cls-meta.xml";
	
	public static String TIMESTAMP_FORMAT = "yyyy/MM/dd HH:mm:ss";
}
