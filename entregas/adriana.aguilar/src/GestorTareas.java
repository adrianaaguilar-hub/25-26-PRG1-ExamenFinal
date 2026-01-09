import java.util.Scanner;

public class GestorTareas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tareas = new String[10];
        boolean[] completadas = new boolean[10];
        int numeroTareas = 0;
        boolean usuarioOnline = true;

        System.out.println("Gestor de Tareas v1.0");

        
            System.out.println("[1] Anadir tarea");
            System.out.println("[2] Marcar tarea como completada");
            System.out.println("[3] Ver tareas pendientes");
            System.out.println("[4] Ver estadisticas");
            System.out.println("[5] Salir");
            System.out.print("Opcion: ");
            int opcionUsuario = sc.nextInt();
            sc.nextLine();
            

            do {
            if (opcionUsuario == 1) {
                if (numeroTareas < 10) {
                    System.out.print("Descripcion de la nueva tarea: ");
                    String descripcionTarea = sc.nextLine();
                    tareas[numeroTareas] = descripcionTarea;
                    completadas[numeroTareas] = false;
                    numeroTareas++;
                    System.out.println("Tarea anadida correctamente.");
                } else {
                    System.out.println("ERROR: No se pueden anadir mas tareas, limite alcanzado.");
                }
            } else if (opcionUsuario == 2) {
                System.out.println("Tareas para Marcar");
                for (int i = 0; i < numeroTareas; i++) {
                    System.out.println(
                            (i + 1) + ". " + tareas[i] + " [" + (completadas[i] ? "Completada" : "Pendiente") + "]");
                }
                if (numeroTareas > 0) {
                    System.out.print("Numero de tarea a marcar como completada: ");
                    int numeroTareaCompletada = sc.nextInt();

                    if (numeroTareaCompletada >= 1 && numeroTareaCompletada <= numeroTareas) {
                        if (!completadas[numeroTareaCompletada - 1]) {
                            completadas[numeroTareaCompletada - 1] = true;
                            System.out.println("Tarea marcada como completada.");
                        } else {
                            System.out.println("Esta tarea ya estaba completada.");
                        }
                    } else {
                        System.out.println("Numero de tarea invalido.");
                    }
                } else {
                    System.out.println("No hay tareas para marcar.");
                }
            } else if (opcionUsuario == 3) {
                System.out.println("Tareas Pendientes");
                boolean hayPendientes = false;
                for (int i = 0; i < numeroTareas; i++) {
                    if (!completadas[i]) {
                        System.out.println((i + 1) + ". " + tareas[i]);
                        hayPendientes = true;
                    }
                }
                if (!hayPendientes) {
                    System.out.println("(No hay tareas pendientes)");
                }
            } else if (opcionUsuario == 4) {
                System.out.println("Estadisticas");
                int contarCompletadas = 0;
                for (int i = 0; i < numeroTareas; i++) {
                    if (completadas[i]) {
                        contarCompletadas++;
                    }
                }
                System.out.println("Total de tareas: " + numeroTareas);
                System.out.println("Tareas completadas: " + contarCompletadas);
                System.out.println("Tareas pendientes: " + (numeroTareas - contarCompletadas));
                if (numeroTareas > 0) {
                    double porcentajeTareasCompletadas = (contarCompletadas * 100.0) / numeroTareas;
                    System.out.println("Porcentaje de completacion: " + porcentajeTareasCompletadas + "%");
                }
            } else if (opcionUsuario == 5) {
                System.out.println("Saliendo del gestor de tareas.");
                usuarioOnline = false;
            } else {
                System.out.println("Opcion no valida. Intente de nuevo.");
            }
            } while (usuarioOnline);
        
        sc.close();
    }
}
