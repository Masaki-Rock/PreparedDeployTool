package com.tools.deploy;

import java.io.File;

public class Const {
	
	public static final String OS_NAME = System.getProperty("os.name").toLowerCase();

	public static String SRC_DIR = Util.getSep() + "src";
	
	public static String DEPLOY_DIR = Util.getSep() + "deploy";
	
	public static String CURRENT_PATH = new File("").getAbsolutePath();
	
	public static String SRC_PATH = "";
	
	public static String DEPLOY_PATH = Const.CURRENT_PATH + Const.DEPLOY_DIR;
	
	public static final String VERSION_API = "44.0";

	public static String MANIFEST_FILE = Util.getSep() + "package.xml";

	public static String[][] META_NAME = new String[][] {
		{"ApexClass","classes"},{"ApexComponent",""}
		,{"ApexPage","pages"},{"ApexTrigger","triggers"}
		,{"AppMenu","appMenus"},{"ApprovalProcess",""}
		,{"AuraDefinitionBundle","aura"},{"AuthProvider",""}
		,{"CallCenter",""},{"Community","communities"}
		,{"ConnectedApp","connectedApps"}
		,{"CustomApplication","applications"}
		,{"CustomApplicationComponent",""}
		,{"CustomLabels","labels"}
		,{"CustomMetadata","customMetadata"}
		,{"CustomObject","objects"}
		,{"CustomObjectTranslation","objectTranslations"}
		,{"CustomPageWebLink",""},{"CustomPermission",""},{"CustomTab","tabs"},{"Dashboard","dashboards"}
		,{"DataCategoryGroup",""},{"Document","documents"},{"DuplicateRule","duplicateRules"}
		,{"FlexiPage","flexipages"},{"Flow","flows"},{"Group","groups"},{"HomePageComponent","homePageLayouts"}
		,{"HomePageLayout",""},{"Layout", "layouts"},{"Letterhead",""},{"MatchingRules","matchingRules"}
		,{"PermissionSet","permissionsets"},{"PostTemplate",""},{"Profile","profiles"},{"Queue",""}
		,{"QuickAction","quickActions"},{"Report","reports"},{"ReportType","reportTypes"},{"Role","roles"}
		,{"Scontrol",""},{"SharingRules","sharingRules"},{"SiteDotCom",""},{"StaticResource","staticresources"}
		,{"Workflow","workflows"}, {"Settings","settings"}};
	
	public static String META_NAME_APEX_CLASS = "ApexClass";
	
	public static String META_NAME_APEX_COMPONENT = "ApexComponent";
	
	public static String META_NAME_APEX_PAGE = "ApexPage";
	
	public static String META_NAME_APEX_TRIGGER = "ApexTrigger";
	
	public static String META_NAME_APP_MENU = "AppMenu";
	
	public static String META_NAME_APPROVAL_PROCESS = "ApprovalProcess";
	
	public static String META_NAME_LIGHTNING_COMPONENT = "AuraDefinitionBundle";
	
	public static String META_NAME_AUTH = "AuthProvider";
	
	public static String META_NAME_CALL_CENTER = "CallCenter";
	
	public static String META_NAME_COMMUNITY = "Community";
	
	public static String META_NAME_CONNECTED_APP = "ConnectedApp";
	
	public static String META_NAME_CUSTOM_APPLICATION = "CustomApplication";
	
	public static String META_NAME_CUSTOM_APPLICATION_COMPONENT = "CustomApplicationComponent";
	
	public static String META_NAME_CUSTOM_LABELS = "CustomLabels";
	
	public static String META_NAME_CUSTOM_METADATA = "CustomMetadata";
	
	public static String META_NAME_CUSTOM_OBJECT = "CustomObject";
	
	public static String META_NAME_CUSTOM_OBJECT_TRANSLATION = "CustomObjectTranslation";
	
	public static String META_NAME_CUSTOM_PAGE_WEB_LINK = "CustomPageWebLink";
	
	public static String META_NAME_CUSTOM_PERMISSION = "CustomPermission";
	
	public static String META_NAME_CUSTOM_TAB = "CustomTab";
	
	public static String META_NAME_DASHBOARD = "Dashboard";
	
	public static String META_NAME_DATA_CATEGORY_GROUP = "DataCategoryGroup";
	
	public static String META_NAME_DOCUMENT = "Document";
	
	public static String META_NAME_DUPLICATE_RULE = "DuplicateRule";
	
	public static String META_NAME_FLEXI_PAGE = "FlexiPage";
	
	public static String META_NAME_FLOW = "Flow";
	
	public static String META_NAME_GROUP = "Group";
	
	public static String META_NAME_HOME_PAGE_COMPONENT = "HomePageComponent";
	
	public static String META_NAME_HOME_PAGE_LAYOUT = "HomePageLayout";
	
	public static String META_NAME_LAYOUT = "Layout";
	
	public static String META_NAME_LETTERHEAD = "Letterhead";
	
	public static String META_NAME_MATCHING_RULES = "MatchingRules";
	
	public static String META_NAME_PERMISSION_SET = "PermissionSet";
	
	public static String META_NAME_POST_TEMPLATE = "PostTemplate";
	
	public static String META_NAME_PROFILE = "Profile";
	
	public static String META_NAME_QUEUE = "Queue";
	
	public static String META_NAME_QUICK_ACTION = "QuickAction";
	
	public static String META_NAME_REPORT = "Report";
	
	public static String META_NAME_REPORT_TYPE = "ReportType";
	
	public static String META_NAME_ROLE = "Role";
	
	public static String META_NAME_SCONTROL = "Scontrol";
	
	public static String META_NAME_SHARING_RULES = "SharingRules";
	
	public static String META_NAME_SITE_DOT_COM = "SiteDotCom";

	public static String META_NAME_STATICSOURCE = "StaticResource";

	public static String META_NAME_WORKFLOW = "Workflow";
	
	public static String META_NAME_SETTINGS = "Settings";
	
	public static String[] APEX_CLASS_EXTENSIONS = new String[] {"[.]cls$","[.]cls-meta[.]xml$"};
	
	public static String[] APEX_TRIGGER_EXTENSIONS = new String[] {"[.]trigger$","[.]trigger-meta[.]xml$"};
	
	public static String[] APEX_STATICSOURCE_EXTENSIONS = new String[] {"[.]staticsource$","[.]staticsource-meta[.]xml$"};
	
	public static String[] LIGHTNING_COMPONENT_EXTENSIONS = new String[] {"[.]cmp$","[.]cmp-meta[.]xml$","[.]css$","[.]design$","Controller[.]js$", "Helper[.]js$"};
	
	public static String IGNORE_FILE_APEX = ".*cls-meta.xml";
	
	public static String TIMESTAMP_FORMAT = "yyyy/MM/dd HH:mm:ss";
	
	public static String EXTENTIONS_REGREX= "[\\[\\]'$']";
}
