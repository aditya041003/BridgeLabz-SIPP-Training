public class CircularTourProblem {
    static class PetrolPump {
        int petrol, distance;
        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int findStartingPoint(PetrolPump[] pumps) {
        int start = 0, end = 1;
        int currPetrol = pumps[start].petrol - pumps[start].distance;

        while (start != end || currPetrol < 0) {
            while (currPetrol < 0 && start != end) {
                currPetrol -= pumps[start].petrol - pumps[start].distance;
                start = (start + 1) % pumps.length;
                if (start == 0) return -1;
            }
            currPetrol += pumps[end].petrol - pumps[end].distance;
            end = (end + 1) % pumps.length;
        }
        return start;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };
        int start = findStartingPoint(pumps);
        System.out.println(start == -1 ? "No solution" : "Start at pump " + start);
    }
}