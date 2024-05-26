package TodoList.View;

import TodoList.Service.TodoListService;
import TodoList.util.InputUtil;

public class ViewTodoList {
    
    private TodoListService todoListService;
            
    public ViewTodoList(TodoListService todoListService) {
                this.todoListService = todoListService;
            }
    public void showTodoList(){
        
        
        while (true) {
            cls();
            System.out.println("TODO LIST\n");

            todoListService.showTodoList();
        
            System.out.println("\nMENU");
            System.out.println("1.Tambah");
            System.out.println("2.Hapus");
            System.out.println("3.Edit");
            System.out.println("x.Keluar");

            

            var pilih = InputUtil.input("pilih");
            if(pilih.equals("1")){
                addTodoList();
            }else if(pilih.equals("2")){
                removeTodoList();
            }else if(pilih.equals("3")){
                editTodoList();
            }else if(pilih.equals("x")){
                break;
            }else{
                // stat = true;
            }
        }  
    }
    
    public void addTodoList(){
                cls();
        System.out.println("Tambah Todo List\n");
        todoListService.showTodoList();
        var tambah = InputUtil.input("Tambah(Ketik x untuk membatalkan)");
        if(!tambah.equals("x")){
            todoListService.addTodoList(tambah);
        }

    }

    public void removeTodoList(){
        cls();
        System.out.println("Hapus Todo list\n");
        todoListService.showTodoList();
        var hapus = InputUtil.input("hapus(ketik x untuk membatalkan)");
        if(!hapus.equals("x")){
            //todo list berhasil dihapus
            todoListService.removeTodoList(Integer.parseInt(hapus));
        }
    }

    public void editTodoList(){

    }

    private static void cls(){
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}
		catch(Exception E){
			System.err.println(E);
		}
	}
}
