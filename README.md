# Практика ООП

## Завдання 1 (01.03.24)

- Створити репозиторій
- Написати просту консольну програму

```java
        System.out.println("Task 1\nEnter something in console: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Your input: " + input);
        scanner.close();
```

## Завдання 2 (04.03.24)

#### Завдання 2.1

- Розробити клас, що серіалізується, для зберігання параметрів і результатів обчислень.

- Використовуючи агрегування, розробити клас для знаходження рішення задачі.


#### Завдання 2.2

- Розробити клас для демонстрації в діалоговому режимі збереження та відновлення стану об'єкта, використовуючи серіалізацію.
- Показати особливості використання transient полів. 



#### Завдання 2.3

#### Завдання 2.4 (Варіант 11)

- Підрахувати кількість повних тетрад у двійковому поданні заданого десяткового числа.
- Тетрада (інформатика) — група з чотирьох послідовних бітів у двійковому запису числа: половина октету, один розряд двійково-десяткового коду

```java
package Task2_4;

/**
 * Підрахування кількості повних тетрад у двійковому поданні заданого десяткового числа.
 * 
 * @author Киричок Софія
 */
public class Tetrads {
    private float number;
    
    public Tetrads(float number){
        this.number = number;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }
    
    public void countTetrads(){
        int intNumBits = Float.floatToIntBits(number);
        String binaryString = Integer.toBinaryString(intNumBits);
        int tetradaCount = binaryString.length() / 4;
        System.out.println("Binary code " + number + ": " + binaryString + ". Amount of full tetrads: " + tetradaCount);
    }
}
```

Робота коду:

```java
        System.out.println("- Task 2.4 -");

        Tetrads tetr = new Tetrads(25.7f);
        tetr.countTetrads();
```

![](images/Screenshot3.PNG)