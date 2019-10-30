from authinticateion import sign_up
from project import project
import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  passwd="01111451253",
  database="python_web_app"
)

id = 0

mycursor = mydb.cursor()


print("welcome to Crowd-Funding Web app")


def print_list():
  print("\n")
  print("-----------------------------")
  print("| please press 1 for signIn |")
  print("| please press 2 for signUp |")
  print("| please press 3 for Exit   |")
  print("-----------------------------")
  print("\n")


print_list()

while True:
  auth_choose = input("please enter your choice : ")

  if auth_choose == "1":
    sign_up.take_email()
    sign_up.take_password("password")

    sql = "SELECT id, email, password FROM MyGuests WHERE email = %s and password = %s"
    val = (sign_up.email, sign_up.password)
    mycursor.execute(sql, val)
    my_result = mycursor.fetchall()
    if len(my_result) == 1:
      print("\n--------------------------------")
      print("Welcome to your favorite app ^_^")
      print("--------------------------------")
      while True:
        project.print_project_list()
        project.choose_menu(mydb, mycursor, my_result[0][0])
        print("\n")
        logout = input("enter 1 for logout 2 for continue : ")
        if logout == "1":
          exit()
        elif logout == "2":
          continue
        else:
          print("-----------------")
          print("error choice")
          print("-----------------")
    else:
      print("error email or password or both")

  elif auth_choose == "2":
    sign_up.take_name("first name")
    sign_up.take_name("last name")
    sign_up.take_email()
    sign_up.take_password("password")
    sign_up.take_password("confirm password")
    sign_up.take_phone_number()

    sql = "INSERT INTO MyGuests (fname, lname, email, password, phone) VALUES (%s, %s, %s, %s, %s)"
    val = (sign_up.fname, sign_up.lname, sign_up.email, sign_up.password, sign_up.phone)
    mycursor.execute(sql, val)
    mydb.commit()

  elif auth_choose == "3":
    exit()
  else:
    print("-----------------")
    print("error choice")
    print("-----------------")
  print_list()
