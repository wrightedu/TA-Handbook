import java.io.*;
import java.util.zip.*;
import java.util.Scanner;
import java.util.Calendar;

class CodeUnpack {

    private static String CURRENT_YEAR = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));

    public static void main(String[] args) throws Exception {

        File dir = new File(".");
        for (File f : dir.listFiles()) {
            String name = f.getName();

            if (!name.contains(CURRENT_YEAR))
                continue;

            String lastName = getLastName(name);
            File newFile = new File("." + File.separatorChar + lastName + ".java");

            // for source files, just rename with the student's last name
            if (name.endsWith(".java")) {
                f.renameTo(newFile);
            }

            // for zip files, first unzip them
            if (name.endsWith(".zip")) {
                System.out.println("Unzipping " + name);
                unzip(f);
                File tempDir = new File("./temp");
                File sourceFile = findSourceFile(tempDir);
                if (sourceFile == null) {
                    System.out.println("Couldn't find the code for " + lastName);
                    continue;
                }
                sourceFile.renameTo(newFile);
                recursiveDelete(tempDir);
                f.delete();
            }
        }

    }

    public static void recursiveDelete(File file) {
        if (!file.isDirectory()) {
            file.delete();
        } else {
            for (File f : file.listFiles()) {
                recursiveDelete(f);
            }
            file.delete();
        }
    }

    public static boolean isDriver(File f) {
        String s = "";
        try {
            Scanner in = new Scanner(f);
            while (in.hasNextLine()) {
                s += in.nextLine();
            }
            in.close();
            return s.contains("public static void main(String");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static File findSourceFile(File file) {
        if (!file.isDirectory()) {
            if (file.getName().endsWith(".java")) {
                if (isDriver(file)) {
                    return file;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } else {
            for (File f : file.listFiles()) {
                File yay = findSourceFile(f);
                if (yay != null) {
                    return yay;
                }
            }
        }
        return null;
    }

    // got these two zip method from
    // https://www.baeldung.com/java-compress-and-uncompress
    public static void unzip(File f) throws Exception {
        File destDir = new File("./temp");
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(f));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            File newFile = newFile(destDir, zipEntry);
            if (zipEntry.isDirectory()) {
                if (!newFile.isDirectory() && !newFile.mkdirs()) {
                    throw new IOException("Failed to create directory " + newFile);
                }
            } else {
                // fix for Windows-created archives
                File parent = newFile.getParentFile();
                if (!parent.isDirectory() && !parent.mkdirs()) {
                    throw new IOException("Failed to create directory " + parent);
                }

                // write file content
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }

    public static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }

    public static String getLastName(String s) {
        s = s.substring(s.indexOf(" - ") + 1);
        s = s.substring(0, s.indexOf(" - "));
        String[] tokens = s.split(" ");
        return tokens[tokens.length - 1].trim();
    }
}
