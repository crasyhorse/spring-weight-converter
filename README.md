# Spring MVC - Weight Converter exercise

This is a simple Spring Boot MVC software that convertes different kinds of weight units.

## How to start?

### Get ready for the exercise

Just clone this repo like this:

```
git clone https://github.com/java-2023-03/java-spring-weight-converter.git java-spring-weight-converter/exercise
```

This will give you the code base you need to start this exercise.

### Let's start

1. Create the package ```de.brightslearning.weightconverter```!

2. Create a new Spring Boot Application (Class) named ```WeightConverterApplication```! It should have a ```main``` method that starts the application!

3. Create a bean named ```de.brightslearning.weightconverter.model.Unit```! It should

* have two private attributes
    * String shortName
    * String longName
* have all the necessary constructors
* Getters and setters for all of its attributes
* a default ```toString``` method

4. Create a bean named ```de.brightslearning.weightconverter.model.DataTransferObject```! It should

* have three private attributes
    * Double value
    * String from
    * String to
* have all the necessary constructors
* Getters and setters for all of its attributes
* a default ```toString``` method

5. Open the service bean named ```de.brightslearning.weightconverter.service.ConverterService```!

* Add an empty constructor that executes the ```initializeConversionMatrix``` method
* Add a ```DataTransferObject convert(String from, String to, Double value)``` method that uses the conversion matrix to convert ```value``` from weight unit ```from``` to weight unit ```to```

6. Create a ```Map<String, Unit>```

* which has the name ```units```
* that is registered in the application context as bean (Hint: You have to create a method and annotate it with the ```@Bean``` annotation)
* that reflects the following table

| Key | Value|
|:---:|------|
| t | ```Unit("t", "Tonne")``` |
| kg| ```Unit("kg", "Kilogramm")``` |
| g | ```Unit("g", "Gramm")``` |
| mg| ```Unit("mg", "Milligramm")``` |

7. Create a controller class named ```de.brightslearning.weightconverter.controller.WeightUnitConverterController```!

8. Create a constructor for the ```de.brightslearning.weightconverter.controller.WeightUnitConverterController``` class that injects the ```ApplicationContext``` and the ```de.brightslearning.weightconverter.service.ConverterService```!

8. Create the ```index``` method! It should

* respond to a GET request to ```/```
* get the ```units``` bean from the application context and inject it into the ```Model```
* inject the ```DataTransferObject``` into the ```Model```
* return the ```/index``` template

9. Create the ```convert``` method! It should

* respond to a POST request to ```/convert```
* take the ```@ModelAttribute``` ```dataTransferObject``` of type ```DataTransferObject``` from the request
* take ```redirectAttributes``` as an argument of type ```RedirectAttributes```
* convert the given weight unit using the ```de.brightslearning.weightconverter.service.ConverterService```
* add the result as flash attribute (```addFlashAttribute()```) to the ```redirectAttributes``` (name: ```result```)
* redirect to ```/```

10. Modify the ```index``` method to take the ```@ModelAttribute``` ```result``` of type ```DataTransferObject```. If ```result``` is not ```null``` it should be added to the ```Model``` (name: ```result```).

END 

## How to get the solution?

### Clone the solution
You are done with this exercise? All you have to do is to clone the "solution" branch of this repo.

```
git clone --branch solution https://github.com/java-2023-03/java-spring-weight-converter.git java-spring-weight-converter/solution

```

### Switch to the solution

If you just want to switch from your local files to the solution you should

1. Stash your local changes

```
git stash
```

2. Switch to the "solution" branch

```
git switch solution
```

If you want to get your local changes back you should

1. Switch back to the "master" branch

```
git switch master
```

2. Unstash your local changes

```
git stash pop
```
