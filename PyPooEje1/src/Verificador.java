//Verificador.java
public class Verificador {
    public static boolean seSobreponen(Rectangulo r1, Rectangulo r2) {
        Coordenada a1 = r1.getEsquina1();
        Coordenada a2 = r1.getEsquina2();
        Coordenada b1 = r2.getEsquina1();
        Coordenada b2 = r2.getEsquina2();

        double r1MinX = Math.min(a1.getX(), a2.getX());
        double r1MaxX = Math.max(a1.getX(), a2.getX());
        double r1MinY = Math.min(a1.getY(), a2.getY());
        double r1MaxY = Math.max(a1.getY(), a2.getY());

        double r2MinX = Math.min(b1.getX(), b2.getX());
        double r2MaxX = Math.max(b1.getX(), b2.getX());
        double r2MinY = Math.min(b1.getY(), b2.getY());
        double r2MaxY = Math.max(b1.getY(), b2.getY());

        boolean noSolapan = r1MaxX <= r2MinX || r2MaxX <= r1MinX ||
                            r1MaxY <= r2MinY || r2MaxY <= r1MinY;

        return !noSolapan;
    }

    public static boolean estanJuntos(Rectangulo r1, Rectangulo r2) {
        // Verificar si comparten lado
        Coordenada a1 = r1.getEsquina1();
        Coordenada a2 = r1.getEsquina2();
        Coordenada b1 = r2.getEsquina1();
        Coordenada b2 = r2.getEsquina2();

        double r1MinX = Math.min(a1.getX(), a2.getX());
        double r1MaxX = Math.max(a1.getX(), a2.getX());
        double r1MinY = Math.min(a1.getY(), a2.getY());
        double r1MaxY = Math.max(a1.getY(), a2.getY());

        double r2MinX = Math.min(b1.getX(), b2.getX());
        double r2MaxX = Math.max(b1.getX(), b2.getX());
        double r2MinY = Math.min(b1.getY(), b2.getY());
        double r2MaxY = Math.max(b1.getY(), b2.getY());

        boolean seJuntanEnX = r1MaxX == r2MinX || r2MaxX == r1MinX;
        boolean seJuntanEnY = r1MaxY == r2MinY || r2MaxY == r1MinY;

        boolean seSuperponenEnY = r1MaxY > r2MinY && r1MinY < r2MaxY;
        boolean seSuperponenEnX = r1MaxX > r2MinX && r1MinX < r2MaxX;

        return (seJuntanEnX && seSuperponenEnY) || (seJuntanEnY && seSuperponenEnX);
    }
}
