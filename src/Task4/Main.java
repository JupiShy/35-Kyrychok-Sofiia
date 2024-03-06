package Task4;

import Task3.View;

/**
 * Виконує визначення та відображення результатів
 *
 * @author Киричок Софія
 * @see Main#main
 */
public class Main extends Task3.Main {

    /**Ініціалізує поле {@linkplain ex02.Main#view view}*/
    public Main(View view) {
        super(view);
    }

    /**
     * Виконується при запуску програми
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}
