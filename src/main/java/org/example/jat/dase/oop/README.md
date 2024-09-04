### 1. Analyze the hierarchy of classes and the code. Will the code be compiled and running ?
A->B->C (Class A is a parent of Class B, Class B is a parent of Class C)

```
public class Test {

    public static void main(String[] args) {
        A ab = new B();
        A ac = new C();
        C cb = (C) new B();
    }
}
```
#### ``Resolution: HierarchyChecker class``

### 2. Create composition and aggregation example.
#### ``Resolution: CompositionCreator class``
#### ``Resolution: AggregationCreator class``

### 3. Analyze the code and explain which of the methods will run

```
public class Test {

    public static void main(String[] args) {
        Test t1= new Test();
        t1.method1(null);
    }
    public void method1(Object o) {
        System.out.println("object call");
    }
    
    public void method1(String o) {
        System.out.println("String call");
    }
}
```

### 4. Analyze the code and refactor it to remove switch expressions (Open-closed Principle)
```
public class Employee {
private String name;
private String type;

public Money calculatePay(Employee e) throws InvalidEmployeeType {
    switch (e.type) {
        case COMMISSIONED:
            return calculateCommissionedPay(e);
        case HOURLY:
            return calculateHourlyPay(e);
        case SALARIED:
            return calculateSalariedPay(e);
        default:
            throw new InvalidEmployeeType(e.type);
        }
}
```
```
public Money calculateBonus(Employee e) throws InvalidEmployeeType {
    switch (e.type) {
        case COMMISSIONED:
            return calculateCommissionedBonus(e);
        case HOURLY:
            return calculateHourlyBonus(e);
        case SALARIED:
            return calculateSalariedBonus(e);
        default:
            throw new InvalidEmployeeType(e.type);
        }
    }
}
```


### 5. Analyze the code and refactor it (Interface segregation):
```
public interface RestaurantInterface {

     void acceptOnlineOrder();
     void acceptTelephoneOrder();
     void acceptWalkInCustomerOrder();
     void payOnline();
     void payInPerson();

}
```


### 6. Consider the following code snippet.
```
public class Test {

    public static void main(String[] args) {
        if (aNumber >= 0)
            if (aNumber == 0)
                System.out.println("first string");
            else
                System.out.println("second string");
        System.out.println("third string");
    }
}
```
What output do you think the code will produce if aNumber is 3?
Write a test program containing the previous code snippet; make aNumber 3. What is the output of the program? Is it what you predicted? Explain why the output is what it is; in other words, what is the control flow for the code snippet?
Using only spaces and line breaks, reformat the code snippet to make the control flow easier to understand.
Use braces, { and }, to further clarify the code.


### 7. Refactor code.
```
public class Resume {
    private int candidateId;
    private String candidateNameAndSurname;
    private String technology;
    private Integer yearsOfExperience;
    
    public int getCandidateId() {
        return candidateId;
    }
    
    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }
    
    public String getCandidateNameAndSurname() {
        return candidateNameAndSurname;
    }
    
    public void setCandidateNameAndSurname(String candidateNameAndSurname) {
        this.candidateNameAndSurname = candidateNameAndSurname;
    }
    
    public String getTechnology() {
        return technology;
    }
    
    public void setTechnology(String technology) {
        this.technology = technology;
    }
    
    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    
    
    public void searchResume() {
        //logic to search resume from some repo goes here
   
    }
}
```