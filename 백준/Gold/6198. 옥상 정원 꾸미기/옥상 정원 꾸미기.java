import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int building = Integer.parseInt(br.readLine());
        int[] buildingHeight = new int[building];
        int[] roofTopGardenCount = new int[building];
        long totalRoofTopGarden = 0;
        for (int idx = 0; idx < building; idx++) {
            buildingHeight[idx] = Integer.parseInt(br.readLine());
        }

        for (int position = building - 1; position >= 0; position--) {
            if (position == building - 1) {
                roofTopGardenCount[position] = 0;
            } else if (position == building - 2) {
                if (buildingHeight[position] > buildingHeight[position + 1]) {
                    roofTopGardenCount[position] = 1;
                    totalRoofTopGarden++;
                } else roofTopGardenCount[position] = 0;
            } else {
                if (buildingHeight[position] > buildingHeight[position + 1]) {
                    roofTopGardenCount[position] = 1 + roofTopGardenCount[position + 1];
                    int preHighestBuilding = (position + 1) + roofTopGardenCount[position + 1] + 1;
                    if (preHighestBuilding >= building) {
                        totalRoofTopGarden += roofTopGardenCount[position];
                        continue;}
                    while (buildingHeight[position] > buildingHeight[preHighestBuilding]) {
                        roofTopGardenCount[position] += (roofTopGardenCount[preHighestBuilding]+1);
                        preHighestBuilding = preHighestBuilding + roofTopGardenCount[preHighestBuilding] + 1;
                        if (preHighestBuilding >= building) break;
                    }
                } else roofTopGardenCount[position] = 0;
                totalRoofTopGarden += roofTopGardenCount[position];
            }
        }

        bw.write(totalRoofTopGarden+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
