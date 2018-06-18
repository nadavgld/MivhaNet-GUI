homepageCtrl:
	public void setModel(Model model) //Sets the main model to the controller
	public void submitLogin(ActionEvent actionEvent) //Checks if username & password are match - redirects to profile page
	public void update(Observable o, Object arg) //Controller implements Observer - waiting for an unpdate from the Observable (Model)
	
profileCtrl:
	public void setModel(Model model) //Sets the main model to the controller
	public void showOpenCourse(ActionEvent actionEvent) //Shows open-new-course form
	public void showCreateUser(ActionEvent actionEvent) //Shows create-new-user form
    	public void addNewUser(ActionEvent actionEvent) //Validates new-user form and passes to the Model to communicate with the DB
    	public void openCourse(ActionEvent actionEvent) //Validates new-course form and passes to the Model to communicate with the DB
	public void update(Observable o, Object arg) //Controller implements Observer - waiting for an unpdate from the Observable (Model)
	

Design Patterns:
Singleton - Using only one Model to communicate between the controllers and the DB - used singleton on the model so there will be only one instance of this class.
Observer-Observable - Using thie design pattern between the model and controller so when the controller ask from the model to communicate with the DB, the model will update whenever there will be an answer.
MVC - Each view(page) is related to a controller of its own, all the controllers are related to only one model that communicates with the DB.