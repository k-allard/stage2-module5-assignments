package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    protected String processorVersion;
    private List<String> stringArrayList = new LinkedList<>();
    private Scanner informationScanner;
    private String processorName;
    private Long period = 10_000_000_000_000L;
    private Integer valueOfCheap;
    private StringBuilder stringBuilder;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        for (String str : stringList) {
            System.out.println(str.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : stringList) {
            stringBuilder.append(str).append(' ');
        }
        return stringBuilder.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        processorVersion = stringBuilder.toString();
    }
}
