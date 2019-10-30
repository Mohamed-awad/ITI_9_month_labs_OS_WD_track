import time
import datetime
from project import new_project
now = datetime.datetime.now()

print(now.strftime("%Y-%m-%d"))


def print_project_list():
  print("\n")
  print("-----------------------------")
  print("| please press 1 for view all projects |")
  print("| please press 2 for create project |")
  print("| please press 3 for search by project name |")
  print("| please press 4 for delete project |")
  print("-----------------------------")
  print("\n")


def choose_menu(my_db, my_cursor, user_id):

    project_choose = input("please enter your choice : ")
    if project_choose == "1":
      sql = "SELECT * FROM projects"
      my_cursor.execute(sql)
      my_result = my_cursor.fetchall()
      for current_project in my_result:
        print(current_project)

    elif project_choose == "2":
      new_project.take_title("title")
      new_project.take_title("details")
      new_project.take_total()
      sql = "INSERT INTO projects (title, details, total_target, project_date, user_id) " \
            "VALUES (%s, %s, %s, %s, %s)"
      val = (new_project.title, new_project.details, new_project.total_target, now.strftime("%Y-%m-%d"), user_id)
      my_cursor.execute(sql, val)
      my_db.commit()

    elif project_choose == "3":
      new_project.take_title("title")
      sql = "select * from projects where title = %s"
      val = (new_project.title,)
      my_cursor.execute(sql, val)
      my_result = my_cursor.fetchall()
      for project in my_result:
        print(project)
    elif project_choose == "4":
      new_project.take_title("title")
      sql = "delete from projects where title = %s and user_id = %s"
      val = (new_project.title, user_id)
      my_cursor.execute(sql, val)
      my_db.commit()
    else:
      print("-----------------")
      print("error choice")
      print("-----------------")
