import java.util.Random;
import java.util.Scanner;

public class game {
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		
		char board[][] = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
		
		while(true)
		{
			printboard(board);
			playerturn(scan, board);
			if(isgameOver(board))
			{
				break;
			}
			computerturn(board);
			if(isgameOver(board))
			{
				break;
			}
		}
		
		scan.close();
	}

	private static boolean isgameOver(char[][] board) {

		if(whowon(board,'X'))
		{
			printboard(board);
			System.out.println("Player win :)");
			return true;
		}
		
		if(whowon(board,'O'))
		{
			printboard(board);
			System.out.println("Computer win :(");
			return true;
		}
		
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[i].length;j++)
			{
				if(board[i][j] == ' ')
				{
					return false;
				}
			}
		}
		
		printboard(board);
		System.out.println("it's tie so, the game ends :)");
		return true;
	}

	private static boolean whowon(char[][] board,char symbol) {
		
		if(board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol ||
				board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol ||
				board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol ||
				
				board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol ||
				board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol ||
				board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol ||
				
				board[0][1] == symbol && board[1][1] == symbol && board[2][2] == symbol ||
				board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
		{
			return true;
		}
		return false;
		
	}
	
	private static void computerturn(char[][]  board)
	{
		int computerinput;
		Random ram = new Random();
		while(true)
		{
			computerinput = ram.nextInt(9)+1;
			if(isvalidmove(board,Integer.toString(computerinput)))
			{
				break;
			}
		}
		System.out.println("Computer chose : "+computerinput);
		computermove(board, Integer.toString(computerinput),'O');
	}

	private static void computermove(char[][] board, String computerinput,char symbol) {
		
		switch(computerinput)
		{
		case "1":
			board[0][0] = symbol;
			break;
		case "2":
			board[0][1] = symbol;
			break;
		case "3":
			board[0][2] = symbol;
			break;
		case "4":
			board[1][0] = symbol;
			break;
		case "5":
			board[1][1] = symbol;
			break;
		case "6":
			board[1][2] = symbol;
			break;
		case "7":
			board[2][0] = symbol;
			break;
		case "8":
			board[2][1] = symbol;
			break;
		case "9":
			board[2][2] = symbol;
			break;
		default:
			System.out.println(":(");
		}
	}
	
	private static void playerturn(Scanner scan,char [][]board)
	{
		String userinput;
		while(true)
		{
			System.out.println("Where you could you like to play? (0-9):");
			userinput = scan.nextLine();
			
			if(isvalidmove(board,userinput))
			{
				break;
			}
			else
			{
				System.out.println(userinput+" is not valid input.");
			}
		}
		playermove(userinput, board,'X');
	}

	private static boolean isvalidmove(char[][] board,String pos) {
		switch(pos)
		{
		case "1":
			return (board[0][0] == ' ');
		case "2":
			return (board[0][1] == ' ');
		case "3":
			return (board[0][2] == ' ');
		case "4":
			return (board[1][0] == ' ');
		case "5":
			return (board[1][1] == ' ');
		case "6":
			return (board[1][2] == ' ');
		case "7":
			return (board[2][0] == ' ');
		case "8":
			return (board[2][1] == ' ');
		case "9":
			return (board[2][2] == ' ');
		default:
			return false;
		}
		
	}

	private static void playermove(String pos, char[][] board,char symbol) {
		
		switch(pos)
		{
		case "1":
			board[0][0] = symbol;
			break;
		case "2":
			board[0][1] = symbol;
			break;
		case "3":
			board[0][2] = symbol;
			break;
		case "4":
			board[1][0] = symbol;
			break;
		case "5":
			board[1][1] = symbol;
			break;
		case "6":
			board[1][2] = symbol;
			break;
		case "7":
			board[2][0] = symbol;
			break;
		case "8":
			board[2][1] = symbol;
			break;
		case "9":
			board[2][2] = symbol;
			break;
		default:
			System.out.println(":(");
		}
	}

	private static void printboard(char[][] board) {
		System.out.println(board[0][0] +"|"+board[0][1]+"|"+board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] +"|"+board[1][1]+"|"+board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] +"|"+board[2][1]+"|"+board[2][2]);
	}
}
