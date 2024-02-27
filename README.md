This is my calculator project when working with both the Model View Presenter (MVP) structure and the Model View View Model (MVVM) structure.

Using the MVP Structure we have a folder labeled:
MVP which has the contents of
MVPFragment.kt (View)
MVPModel (Model)
MVPPresenter (Presenter)

Using the MVVM Strucutre we have a folder labeled:
MVVM which has the contents of
MVVMFragment (View)
MVVMModel (Model)
MVVMViewModel (ViewModel)

We also have the MainActivity.kt which helps inflate the application.

In the Navigation Graph we have the MainActivity linked so that the HomeFragment appears.

The HomeFragment holds two buttons.
One is the MVP Layout button which directs the user to the calculator using the MVP structure.
The other is the MVVM Layout button which directs the user to the calculator using the MVVM structure.

From there it's a basic calculator which can do Addition, Subtraction, Mulitplicaiton, and Division.

The inputs are cleared once a operation is selected.
Any input error is handled with Toast messages, i.e. Dividing by 0 or empty inputs.

Here is the link to my GitHub Repo:
https://github.com/zpulichino/cs4520-assg3-starter-code/tree/main 
