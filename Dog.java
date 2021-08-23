import java.util.Calendar;
import java.util.Objects;

// Add appropriate visibility modifiers (public or private)
// to class, instance variables, constructors, and methods
class Dog{
	
	String name;
	int numEyes;
	int numLegs;
	Date birth;
	Date death;
	int currentYear = Calendar.getInstance().get(Calendar.YEAR);

	Dog(String theName, int theNumEyes, int theNumLegs, Date theBirth){
		//check for valid parameters: eyes, legs, and age range
		//if valid, assign
		//if not valid, print that object was not created.
	}

	Dog(String theName, int theNumEyes, int theNumLegs, Date theBirth, Date theDeath){
		//check for valid parameters: eyes, legs, and age range
		//if valid, assign
		//if not valid, print that object was not created.
	}

	String getName(){
		return name;
	}

	int getNumEyes(){
		return numEyes;
	}

	int getNumLegs(){
		return numLegs;
	}

	Date getBirth(){
		return birth;
	}

	Date getDeath(){
		return death;
	}

	void setName(String theNewName){
		name = theNewName;
	}

	void setNumEyes(int theNewNumEyes){
		// check for valid input before assigning. If not valid, print a message.		
	}

	void setNumLegs(int theNewNumLegs){
		// check for valid input before assigning. If not valid, print a message.
	}	

	void setBirth(Date theNewBirth){
		// check for valid age range before assigning. If not valid, print a message.
	}

	void setDeath(Date theNewDeath){
		// check for valid age range before assigning. If not valid, print a message.
	}

	String toString(){
		String toReturn = "";
		if(Objects.isNull(death)){
			int age = currentYear - birth.getYear();
			toReturn += name + " has " + numEyes + " eyes and " + numLegs + " legs and is " + age + " years old.";
		}else{
			toReturn += name + " had " + numEyes + " eyes and " + numLegs + " legs and was born on " + birth + " and died on " + death + ".";
		}
		return toReturn;
	} 


	boolean isValidAge(Date theBirth, Date theDeath){
		boolean valid = false;
		if(Objects.isNull(theDeath)){ 
			int age = currentYear - theBirth.getYear();
			if(age <= 13 && age >= 0){
				valid = true;
				if(age==0){
					int birthMonth = monthToNum(theBirth.getMonth());
					int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
					if(currentMonth < birthMonth){
						valid = false;
					} else if(currentMonth == birthMonth){
						int birthDay = theBirth.getDay();
						int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
						if(currentDay < birthDay){
							valid = false;
						}
					}
				}
			}
		}else{
			int age = theDeath.getYear() - theBirth.getYear();
			if (age <= 13 && age >= 0){
				valid = true;
				if(age==0){
					int birthMonth = monthToNum(theBirth.getMonth());
					int deathMonth = monthToNum(theDeath.getMonth());
					if(birthMonth > deathMonth){
						valid = false;
					}else if (birthMonth == deathMonth){
						int birthDay = theBirth.getDay();
						int deathDay = theDeath.getDay();
						if(birthDay > deathDay){
							valid = false;
						}
					}
				}
			}
		}
		return valid;
	}

	boolean isValidNumEyes(int theNumEyes){
		boolean valid = false;
		if(theNumEyes >= 0 && theNumEyes <= 2){
			valid = true;
		}
		return valid; 
	}

	boolean isValidNumLegs(int theNumLegs){
		boolean valid = false;
		if(theNumLegs >= 0 && theNumLegs <= 4){
			valid = true;
		}
		return valid; 
	}

	int monthToNum(String month){
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; 
		int i = 0;
		for(String m : months){
			i++;
			if (m==month){
				break;
			}
		}
		return i;
	}
	


}