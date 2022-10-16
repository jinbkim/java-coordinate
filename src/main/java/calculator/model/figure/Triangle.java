package calculator.model.figure;

import calculator.model.Point;
import calculator.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Triangle extends AbstractFigure {

    private static final int NUM_OF_TRIANGLE_SIDES = 3;

    public Triangle(List<Integer> positions) {
        super(positions);
        if (!isTriangle()) {
            throw new IllegalArgumentException(OutputView.WRONG_COORDINATE_FORM);
        }
    }

    @Override
    public void printResult() {

    }

    private boolean isTriangle() {
        List<Double> triangleSidesInclinations = getTriangleSidesInclination();

        if (triangleSidesInclinations.stream()
            .distinct()
            .count() == NUM_OF_TRIANGLE_SIDES) {
            return true;
        }
        return false;
    }

    private List<Double> getTriangleSidesInclination() {
        List<Double> triangleSidesInclinations = new ArrayList<>();

        for (int i = 0; i < NUM_OF_TRIANGLE_SIDES; i++) {
            Point pointA = points.get(i % NUM_OF_TRIANGLE_SIDES);
            Point pointB = points.get((i + 1) % NUM_OF_TRIANGLE_SIDES);

            triangleSidesInclinations.add(pointA.getInclination(pointB));
        }
        return triangleSidesInclinations;
    }
}