package game2048;
import java.util.*;

public class Game2048 
{
	static Scanner scan;
	public static void whichDirectionNext(int[][] gameField, int n)
	{
		scan = new Scanner(System.in);
		System.out.println("In which direction do you want to swipe (right, left, up, down)?");
		String line = scan.nextLine();
		if(line.equals("right"))
			gameField = swipeRight(gameField,n);
		else if(line.equals("left"))
			gameField = swipeLeft(gameField,n);
		else if(line.equals("up"))
			gameField = swipeUp(gameField,n);
		else if(line.equals("down"))
			gameField = swipeDown(gameField,n);
		else
		{
			System.out.println(line +" is a wrong input");
			whichDirectionNext(gameField,n);
		}
	}
	public static void printGame(int[][] gameField, int n)
	{
		System.out.println("+++++++++++++++++++++");
		for(int i = 0; i < n; i++)
		{
			if(gameField[i][0] < 10)
				System.out.print("|  ");
			else if(gameField[i][0] < 1000)
				System.out.print("| ");
			else if(gameField[i][0] < 10000)
				System.out.print("|");
			for(int j = 0; j < n; j++)
			{
				if(j < n-1)
				{
					if(gameField[i][j] < 100)
						System.out.print(gameField[i][j] + " |");
					else if(gameField[i][j] < 10000)
						System.out.print(gameField[i][j] + "|");
					if(gameField[i][j+1] < 10)
						System.out.print("  ");
					else if(gameField[i][j+1] < 1000)
						System.out.print(" ");
					else if(gameField[i][j+1] < 10000)
						System.out.print("");
				}
				else
				{
					if(gameField[i][j] < 100)
						System.out.print(gameField[i][j] + " |");
					else if(gameField[i][j] < 10000)
						System.out.print(gameField[i][j] + "|");
				}
			}
			System.out.println();
			System.out.println("+++++++++++++++++++++");
		}
	}
	public static int[][] swipeRight(int[][] gameField, int n)
	{
		boolean ifChanged = false;
		for(int i = 0; i < n; i++)
		{
			for(int j = n-1; j > 0; j--)
			{
				if(gameField[i][j] > 0)
				{
					for(int k = j-1; k > -1; k--)
					{
						if(gameField[i][j] == gameField[i][k])
						{
							gameField[i][j] += gameField[i][k];
							gameField[i][k] = 0;
							ifChanged = true;
							break;
						}
						else if(gameField[i][k] > 0)
							break;
					}
				}
				else if(gameField[i][j] == 0)
				{
					for(int k = j-1; k > -1; k--)
					{
						if(gameField[i][k] > 0)
						{
							gameField[i][j] = gameField[i][k];
							gameField[i][k] = 0;
							ifChanged = true;
							j++;
							break;
						}
					}
				}
			}
		}
		if(!ifChanged)
		{
			System.out.println("You can't swipe in that direction!");
			whichDirectionNext(gameField,n);
		}
		return gameField;
	}
	public static int[][] swipeLeft(int[][] gameField, int n)
	{
		boolean ifChanged = false;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n-1; j++)
			{
				if(gameField[i][j] > 0)
				{
					for(int k = j+1; k < n; k++)
					{
						if(gameField[i][j] == gameField[i][k])
						{
							gameField[i][j] += gameField[i][k];
							gameField[i][k] = 0;
							ifChanged = true;
							break;
						}
						else if(gameField[i][k] > 0)
							break;
					}
				}
				else if(gameField[i][j] == 0)
				{
					for(int k = j+1; k < n; k++)
					{
						if(gameField[i][k] > 0)
						{
							gameField[i][j] = gameField[i][k];
							gameField[i][k] = 0;
							ifChanged = true;
							j--;
							break;
						}
					}
				}
			}
		}
		if(!ifChanged)
		{
			System.out.println("You can't swipe in that direction!");
			whichDirectionNext(gameField,n);
		}
		return gameField;
	}
	public static int[][] swipeUp(int[][] gameField, int n)
	{
		boolean ifChanged = false;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n-1; j++)
			{
				if(gameField[j][i] > 0)
				{
					for(int k = j+1; k < n; k++)
					{
						if(gameField[j][i] == gameField[k][i])
						{
							gameField[j][i] += gameField[k][i];
							gameField[k][i] = 0;
							ifChanged = true;
							break;
						}
						else if(gameField[k][i] > 0)
							break;
					}
				}
				else if(gameField[j][i] == 0)
				{
					for(int k = j+1; k < n; k++)
					{
						if(gameField[k][i] > 0)
						{
							gameField[j][i] = gameField[k][i];
							gameField[k][i] = 0;
							ifChanged = true;
							j--;
							break;
						}
					}
				}
			}
		}
		if(!ifChanged)
		{
			System.out.println("You can't swipe in that direction!");
			whichDirectionNext(gameField,n);
		}
		return gameField;
	}
	public static int[][] swipeDown(int[][] gameField, int n)
	{
		boolean ifChanged = false;
		for(int i = 0; i < n; i++)
		{
			for(int j = n-1; j > 0; j--)
			{
				if(gameField[j][i] > 0)
				{
					for(int k = j-1; k > -1; k--)
					{
						if(gameField[j][i] == gameField[k][i])
						{
							gameField[j][i] += gameField[k][i];
							gameField[k][i] = 0;
							ifChanged = true;
							break;
						}
						else if(gameField[k][i] > 0)
							break;
					}
				}
				else if(gameField[j][i] == 0)
				{
					for(int k = j-1; k > -1; k--)
					{
						if(gameField[k][i] > 0)
						{
							gameField[j][i] = gameField[k][i];
							gameField[k][i] = 0;
							ifChanged = true;
							j++;
							break;
						}
					}
				}
			}
		}
		if(!ifChanged)
		{
			System.out.println("You can't swipe in that direction!");
			whichDirectionNext(gameField,n);
		}
		return gameField;
	}
	public static boolean doYouLost(int[][] gameField, int n)
	{
		int[][] gameFieldTemp = new int [n][n];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				gameFieldTemp[i][j] = gameField[i][j];
			}
		}
		boolean ifChanged = false;
		for(int i = 0; i < n; i++)
		{
			for(int j = n-1; j > 0; j--)
			{
				if(gameFieldTemp[i][j] > 0)
				{
					for(int k = j-1; k > -1; k--)
					{
						if(gameFieldTemp[i][j] == gameFieldTemp[i][k])
						{
							gameFieldTemp[i][j] += gameFieldTemp[i][k];
							gameFieldTemp[i][k] = 0;
							ifChanged = true;
							break;
						}
						else if(gameFieldTemp[i][k] > 0)
							break;
					}
				}
				else if(gameFieldTemp[i][j] == 0)
				{
					for(int k = j-1; k > -1; k--)
					{
						if(gameFieldTemp[i][k] > 0)
						{
							gameFieldTemp[i][j] = gameFieldTemp[i][k];
							gameFieldTemp[i][k] = 0;
							ifChanged = true;
							j++;
							break;
						}
					}
				}
			}
		}
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n-1; j++)
			{
				if(gameFieldTemp[i][j] > 0)
				{
					for(int k = j+1; k < n; k++)
					{
						if(gameFieldTemp[i][j] == gameFieldTemp[i][k])
						{
							gameFieldTemp[i][j] += gameFieldTemp[i][k];
							gameFieldTemp[i][k] = 0;
							ifChanged = true;
							break;
						}
						else if(gameFieldTemp[i][k] > 0)
							break;
					}
				}
				else if(gameFieldTemp[i][j] == 0)
				{
					for(int k = j+1; k < n; k++)
					{
						if(gameFieldTemp[i][k] > 0)
						{
							gameFieldTemp[i][j] = gameFieldTemp[i][k];
							gameFieldTemp[i][k] = 0;
							ifChanged = true;
							j--;
							break;
						}
					}
				}
			}
		}
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n-1; j++)
			{
				if(gameFieldTemp[j][i] > 0)
				{
					for(int k = j+1; k < n; k++)
					{
						if(gameFieldTemp[j][i] == gameFieldTemp[k][i])
						{
							gameFieldTemp[j][i] += gameFieldTemp[k][i];
							gameFieldTemp[k][i] = 0;
							ifChanged = true;
							break;
						}
						else if(gameFieldTemp[k][i] > 0)
							break;
					}
				}
				else if(gameFieldTemp[j][i] == 0)
				{
					for(int k = j+1; k < n; k++)
					{
						if(gameFieldTemp[k][i] > 0)
						{
							gameFieldTemp[j][i] = gameFieldTemp[k][i];
							gameFieldTemp[k][i] = 0;
							ifChanged = true;
							j--;
							break;
						}
					}
				}
			}
		}
		for(int i = 0; i < n; i++)
		{
			for(int j = n-1; j > 0; j--)
			{
				if(gameFieldTemp[j][i] > 0)
				{
					for(int k = j-1; k > -1; k--)
					{
						if(gameFieldTemp[j][i] == gameFieldTemp[k][i])
						{
							gameFieldTemp[j][i] += gameFieldTemp[k][i];
							gameFieldTemp[k][i] = 0;
							ifChanged = true;
							break;
						}
						else if(gameFieldTemp[k][i] > 0)
							break;
					}
				}
				else if(gameFieldTemp[j][i] == 0)
				{
					for(int k = j-1; k > -1; k--)
					{
						if(gameFieldTemp[k][i] > 0)
						{
							gameFieldTemp[j][i] = gameFieldTemp[k][i];
							gameFieldTemp[k][i] = 0;
							ifChanged = true;
							j++;
							break;
						}
					}
				}
			}
		}
		if(!ifChanged)
			return true;
		return false;
	}
	public static int[][] addingNewNumber(int[][] gameField, int n)
	{
		Random rand = new Random();
		boolean value = rand.nextInt(10) == 0;
		int blankPlacesCounter = 0;
		int currentCounter = 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(gameField[i][j] == 0)
					blankPlacesCounter++;
			}
		}
		int where = rand.nextInt(blankPlacesCounter)+1;
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(gameField[i][j] == 0)
					currentCounter++;
				if(currentCounter == where)
				{
					if(value == false)
						gameField[i][j] = 2;
					else
						gameField[i][j] = 4;
					return gameField;
				}
			}
		}
		return gameField;
	}
	public static void main(String[] args) 
	{
		int n = 4;
		int score = 0;
		int blankPlacesCounter = 0;
		int[][] gameField = new int[n][n];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				gameField[i][j] = 0;
			}
		}
		System.out.println("=============================================");
		System.out.println("Welcome to the game 2048");
		System.out.println("=============================================");
		while(true)
		{
			gameField = addingNewNumber(gameField,n);
			printGame(gameField,n);
			if(doYouLost(gameField,n) == true)
				break;
			System.out.println();
			whichDirectionNext(gameField,n);
			System.out.println();
			blankPlacesCounter = 0;
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
				{
					if(gameField[i][j] == 0)
						blankPlacesCounter++;
				}
			}
			if(blankPlacesCounter == 0)
				break;
		}
		System.out.println();
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				score += gameField[i][j];
				if(gameField[i][j] > 1024)
				{
					System.out.println("=============================================");
					System.out.println("You won!");
					System.out.println("=============================================");
					return;
				}
			}
		}
		System.out.println("=============================================");
		System.out.println("You lost! Your score is "+ score);
		System.out.println("=============================================");
	}
}
