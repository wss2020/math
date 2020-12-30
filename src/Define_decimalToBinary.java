public class Define_decimalToBinary {
    public static String decimalToBinary(int decimalSource) {
        if(decimalSource==-2147483648) {
            return "10000000 00000000 00000000 00000000";
        }
        int[] bits = new int[32];
        int i = 32;
        StringBuffer sb = new StringBuffer();

        int result = decimalSource;

        if(decimalSource<0) {
            result = -decimalSource;
        }

        while(result!=0) {
            i--;
            bits[i] = result%2;
            result = result/2;
        }

        if(decimalSource<0) {
            // 负数全部取反
            for(int j = 0; j<bits.length; j++) {
                bits[j] = bits[j]^1;
            }
            // 最高位置为1
            bits[0] = 1;
            // 补1
            for(int j = 31; j>=0; j--) {
                if(bits[j]==0) {
                    bits[j]=1;
                    break;
                } else {
                    bits[j]=0;
                    continue;
                }
            }
        }

        for(int j = 0; j<bits.length; j++) {
            if(j%8==0) {
                sb.append(" ");
            }
            sb.append(bits[j]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        int a = 10;
        int b = 100;
        int c = 2;
        int d = -2; // 负数转换成二进制，就是正数的补码，末尾加1
        System.out.println(String.format("数字%d的二进制是%s", a, decimalToBinary(a)));	//获取十进制数10的二进制数
        System.out.println(String.format("数字%d的十进制是%s", b, decimalToBinary(b)));	//获取二进制数100的二进制数
        System.out.println(String.format("数字%d的十进制是%s", c, decimalToBinary(c)));	//获取二进制数1的二进制数
        System.out.println(String.format("数字%d的十进制是%s", d, decimalToBinary(d)));
    }
}
