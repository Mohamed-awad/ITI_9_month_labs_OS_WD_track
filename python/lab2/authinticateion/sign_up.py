import re
fname = ""
lname = ""
email = ""
password = ""
phone = ""


def has_numbers(user_name):
  return any(char.isdigit() for char in user_name)


def is_valid_email(email):
  if len(email) > 7:
    if re.match('^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$', email):
      return True
    return False


def validate_password(current_pass):

  if len(current_pass) < 8:
    print("Make sure your password is at lest 8 letters")
    return False
  elif re.search('[0-9]',current_pass) is None:
    print("Make sure your password has a number in it")
    return False
  elif re.search('[A-Z]',current_pass) is None:
    print("Make sure your password has a capital letter in it")
    return False
  elif re.search('[a-z]',current_pass) is None:
    print("Make sure your password has a small letter in it")
    return False
  return True


def is_valid_phone(my_phone):
  if re.match("^01[1,5,2,0][0-9]{8}$", my_phone):
    return True
  return False


def take_name(name):
  while True:
    my_name = input("enter your " + name + " : ")
    if my_name and not has_numbers(my_name) :
      if name == "first name" :
        global fname
        fname = my_name
      else:
        global lname
        lname = my_name
      break


def take_email():
  global email
  while True:
    email = input("enter your email : ")
    if is_valid_email(email):
      break


def take_password(key):
  while True:
    my_pass = input("enter your " + key + " : ")
    if validate_password(my_pass):
      if key == "password":
        global password
        password = my_pass
        break
      else:
        # global password
        if password == my_pass:
          print("password matched")
          break
        else:
          print("password mis match")


def take_phone_number():
  global phone
  while True:
    phone = input("enter your phone number : ")
    if is_valid_phone(phone):
      break

