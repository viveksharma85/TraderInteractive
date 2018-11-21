package com.trader.stringdata;

public class Strings {

	public enum Messages {
		Invalid_UserName_Password("Invalid username or password"), 
		Existing_Email("A customer already exists with email address"), 
		Invalid_Email("Please enter a valid email address."), 
		Newsletter_Signup("Thanks for signing up!");

		public String value;

		private Messages(String value) {
			this.value = value;
		}
	}

	public enum SectionHeading {
		Interested_Used_Bikes("Interested in Used Bikes?"), 
		StayConnect("Stay Connected"), 
		Give_Feedback("Give Us Feedback"), 
		Explore_CycleTrader("Explore Cycle Trader"), 
		CycleTrader_Newsletter("Cycle Trader Newsletters"), 
		CycleTrader_Affiliates("Cycle Trader Affiliates"), 
		Dealer_Fuel("Dealer Fuel"), 
		Follow_US("Follow Us"),
		Find_Motorcycle_Sale("Find Motorcycles For Sale"),
		Find_By_State("Find by State");

		public String value;

		private SectionHeading(String value) {
			this.value = value;
		}
	}

	public enum PopularTabs {
		PopularMakes("Popular Motorcycle Makes"), 
		PopularTypes("Popular Motorcycle Types"), 
		PopularStates("Popular States");

		public String value;

		private PopularTabs(String value) {
			this.value = value;
		}
	}

	public enum Menus {
		MotorcyclesForSale("MOTORCYCLES FOR SALE"), 
		SellForFree("SELL FOR FREE"), 
		Research("RESEARCH"), 
		RaceTeam("RACE TEAM"), 
		News("NEWS"), 
		MotorcycleDealers("MOTORCYCLE DEALERS");

		public String value;

		private Menus(String value) {
			this.value = value;
		}
	}

	public enum ModelList {
		NINJA("NINJA"), 
		ELECTRA_GLIDE("Glide"), 
		Honda_CRF("");

		public String value;

		private ModelList(String value) {
			this.value = value;
		}
	}
	
	public enum DealerSorting {
		Nearest("Nearest"),
		Name("Name");

		public String value;

		private DealerSorting(String value) {
			this.value = value;
		}
	}

	public enum State {
		Alabama("Alabama"), 
		California("California"), 
		Florida("Florida"), 
		Georgia("Georgia"), 
		Illinois("Illinois"), 
		Michigan("Michigan"), 
		North_Carolina("North Carolina"), 
		Ohio("Ohio"), 
		Pennsylvania("Pennsylvania"), 
		Texas("Texas"), 
		Wisconsin("Wisconsin");

		public String value;

		private State(String value) {
			this.value = value;
		}
	}

	public enum Button {
		SignIn("Sign In"), 
		Apply("Apply"), 
		Apply_All("Apply All"),
		Cancel("Cancel"), 
		Post_For_Free("Post for Free"), 
		Check_It_Out("Check it Out"), 
		Give_FeedBack("Give Feedback"), 
		Career("Careers"),
		Saved_This_Search("Saved"),
		Find_By_Make("Find By Make"),
		Find_By_Type("Find By Type"),
		Find_By_State("Find By State");

		public String value;

		private Button(String value) {
			this.value = value;
		}
	}

	public enum Tab {
		Search_Tab("Search");
		public String value;

		private Tab(String value) {
			this.value = value;
		}
	}

	public enum PageName {
		Search_Result("Motorcycles"), 
		Advanced_Search("Find Motorcycles For Sale"), 
		BMW_Search_Result("BMW Motorcycles"), 
		CANAM_Search_Result("Can-Am Motorcycles"), 
		Ducati_Search_Result("Ducati Motorcycles"), 
		Harley_Search_Result("Harley-Davidson Motorcycles"), 
		Honda_Search_Result("Honda Motorcycles"),
		KTM_Search_Result("KTM Motorcycles"), 
		Kawasaki_Search_Result("Kawasaki Motorcycles"), 
		Suzuki_Search_Result("Suzuki Motorcycles"), 
		Triumph_Search_Result("Triumph Motorcycles"),
		Victory_Search_Result("Victory Motorcycles"), 
		Yamaha_Search_Result("Yamaha Motorcycles"), 
		SearchAll_Search_Result("Motorcycles For Sale by Make"), 
		KAWASAKI_NINJA("Kawasaki NINJA Motorcycles"), 
		ELECTRA_GLIDE("Harley-Davidson ELECTRA GLIDE Motorcycles"),
		HONDA_CRF("Honda CRF Motorcycles"), 
		HONDA_CBR("Honda CBR Motorcycles"), 
		Street_Glide("Harley-Davidson STREET GLIDE Motorcycles"), 
		KAWASAKI_VULCAN("Kawasaki VULCAN Motorcycles"), 
		Spyder_Can("Can-Am SPYDER Motorcycles"), 
		YAMAHA_YZF("Yamaha YZF Motorcycles"), 
		YAMAHA_V_STAR("Yamaha V STAR Motorcycles"), 
		Road_Glide("Harley-Davidson ROAD GLIDE Motorcycles"), 
		Find_By_Make("Motorcycles For Sale by Make"), 
		Find_By_Type("Motorcycles For Sale by Type"), 
		Find_By_State("Motorcycles For Sale by State"), 
		Research_Page("Research Motorcycles - Motorcycle Resources"), 
		Race_Team("RACE TEAM"), 
		News_Page("CYCLE NEWS"), 
		Find_Motorcycle_Dealers("Find Motorcycle Dealers"), 
		Dealer_Result_Page("motorcycle dealers"), 
		Sell_Motorcycle("Sell your motorcycle\r\n" + "fast, free & secure"), 
		Dealer_Centre("Welcome to Cycle Trader's");

		public String value;

		private PageName(String value) {
			this.value = value;
		}
	}

	public enum Types {
		Cruiser("Cruiser"), 
		Dirtbikes("Dirt Bike"), 
		Sportbikes("Sportbike"), 
		Standards("Standard"), 
		Touring("Touring");

		public String value;

		private Types(String value) {
			this.value = value;
		}
	}

	public enum FooterLinks{
		Security_Center("Security Center"),
		Advertiser_Agreement("Advertiser Agreement"),
		Community_Guidelines("Community Guidelines"),
		Copyright("Copyright"),
		Privacy_Policy("Privacy Policy"),
		Terms_Use("Terms of Use");	
	
		public String value;

		private FooterLinks(String value) {
			this.value = value;
		}
	}
	
	public enum MenuLinks{
		HOME("Sidebar Nav - Home"),
		FIND_MOTORCYCLE("Advanced Search"),
		Sell_Motorcycle("Sell My Motorcycle"),
		MyTrader_SignIn("MyTrader Sign In"),
		Dealer_Center("Dealer Center"),
		Motorcycle_Resources("Motorcycle Resources"),
		Need_Help("Need Help"),
		Advanced_Search("Advanced SearchLink"),
		Parts_Gear("Find Parts, Gear, & More"),
		Dealer_Search("Dealer Search"),
		Motorcycle_Research("Motorcycle Research"),
		Race_Team("Race Team"),
		News("News"),
		Feedback("Give Cycle Trader Feedback");
		public String value;

		private MenuLinks(String value) {
			this.value = value;
		}
	}
	
	public enum RefineOptions{
		LOCATION("Location"),
		KEYWORD("Keyword"),
		TYPE("Type"),
		MAKE("Make"),
		MODEL("Model"),
		TRIM("Trim"),
		CATAGORY("Category"),
		PRICE("Price"),
		NEW_USED("New or Used"),
		YEAR("Year"),
		SELLER_TYPE("Seller Type"),
		MILEAGE("Mileage"),
		ENGINE_SIZE("Engine Size"),
		STATE("State"),
		CITY("City");
		public String value;

		private RefineOptions(String value) {
			this.value = value;
		}
	}
	
	public enum FooterSection{
		FIND_BY_MAKE("Find by Make"),
		FIND_BY_TYPE("Find by Type"),
		FIND_BY_State("Find by State"),
		FIND_DEALERS("Find Motorcycle Dealers");
		public String value;

		private FooterSection(String value) {
			this.value = value;
		}
	}
}
