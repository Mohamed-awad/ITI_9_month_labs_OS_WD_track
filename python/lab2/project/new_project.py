
title = ""
details = ""
total_target = 0


def has_numbers(user_name):
  return any(char.isdigit() for char in user_name)


def take_title(name):
  while True:
    my_name = input("enter project " + name + " : ")
    if my_name and not has_numbers(my_name):
      if name == "title":
        global title
        title = my_name
      else:
        global details
        details = my_name
      break


def take_total():
  while True:
    total = input("enter project total target : ")
    try:
      val = int(total)
      global total_target
      total_target = val
      break
    except ValueError:
      print("That's not an int!")

