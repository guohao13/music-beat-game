/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_beat_1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author tjddn
 */
public class DynamicBeat extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;

    private ImageIcon exitButtonEnteredImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/exitButtonEntered.png"));
    private ImageIcon exitButtonBasicImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/exitButtonBasic.png"));
    private ImageIcon startButtonBasicImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/startButtonBasic.png"));
    private ImageIcon startButtonEnteredImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/startButtonEntered.png"));
    private ImageIcon quitButtonBasicImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/quitButtonBasic.png"));
    private ImageIcon quitButtonEnteredImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/quitButtonEntered.png"));
    private ImageIcon leftButtonBasicImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/leftButtonBasic.png"));
    private ImageIcon leftButtonEnteredImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/leftButtonEntered.png"));
    private ImageIcon rightButtonBasicImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/rightButtonBasic.png"));
    private ImageIcon rightButtonEnteredImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/rightButtonEntered.png"));

    private ImageIcon easyButtonBasicImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/easyButtonBasic.png"));
    private ImageIcon easyButtonEnteredImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/easyButtonEntered.png"));
    private ImageIcon hardButtonBasicImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/hardButtonBasic.png"));
    private ImageIcon hardButtonEnteredImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/hardButtonEntered.png"));

    private ImageIcon backButtonEnteredImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/backButtonEntered.png"));
    private ImageIcon backButtonBasicImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/backButtonBasic.png"));

    private Image background = new ImageIcon(Dynamic_beat_1.class.getResource("../images/introBackground.png")).getImage();

    private JLabel menuBar = new JLabel(new ImageIcon(Dynamic_beat_1.class.getResource("../images/menuBar.png")));

    private JButton exitButton = new JButton(exitButtonBasicImage);
    private JButton startButton = new JButton(startButtonBasicImage);
    private JButton quitButton = new JButton(quitButtonBasicImage);
    private JButton leftButton = new JButton(leftButtonBasicImage);
    private JButton rightButton = new JButton(rightButtonBasicImage);
    private JButton easyButton = new JButton(easyButtonBasicImage);
    private JButton hardButton = new JButton(hardButtonBasicImage);
    private JButton backButton = new JButton(backButtonBasicImage);

    private int mouseX, mouseY;

    private boolean isMainScreen = false;
    private boolean isGameScreen = false;

    ArrayList<Track> trackList = new ArrayList<Track>();

    private Image titleImage;
    private Image selectedImage;
    private Music introMusic = new Music("introMusic.mp3", true);
    private Music selectedMusic;
    private int nowSelected = 0;

    public static Game game;

    public DynamicBeat() {
        trackList.add(new Track("Crush Title Image.png", "Crush Start Image.png", "Crush Game Image.png",
                "(trim)Crush - whatever you do.mp3", "Crush - whatever you do.mp3", "Crush - whatever you do"));

        trackList.add(new Track("Jazzyfact Title Image.png", "jazzyfact Start Image.png", "jazzyfact Game Image.png",
                "(trim)Jazzyfact - waste of time.mp3", "Jazzyfact - waste of time.mp3", "Jazzyfact - waste of time"));

        trackList.add(new Track("Sik-k Title Image.png", "iffy Start Image.png", "iffy Game Image.png",
                "(trim)iffy.mp3", "iffy.mp3", "Sik-k - iffy"));

        setUndecorated(true);
        setTitle("Dynamic Beat");
        setSize(Dynamic_beat_1.SCREEN_WIDTH, Dynamic_beat_1.SCREEN_HEIGHT);
        setResizable(false);
        //창이 모니터 정 중앙에 온다.
        setLocationRelativeTo(null);
        //게임창 종료시 프로그램 종료        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);

        //keyListener 추가
        addKeyListener(new KeyListener());

        introMusic.start();

        exitButton.setBounds(1245, -1, 30, 30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonEnteredImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEntered.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonBasicImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("buttonPressed.mp3", false);
                buttonPressedMusic.start();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });

        add(exitButton);

        startButton.setBounds(1010, 480, 300, 100);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startButtonEnteredImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEntered.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonBasicImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("buttonPressed.mp3", false);
                buttonPressedMusic.start();
                //게임시작 이벤트
                enterMain();
            }
        });

        add(startButton);

        quitButton.setBounds(1010, 550, 300, 100);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                quitButton.setIcon(quitButtonEnteredImage);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEntered.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                quitButton.setIcon(quitButtonBasicImage);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("buttonPressed.mp3", false);
                buttonPressedMusic.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);

            }
        });

        add(quitButton);

        leftButton.setVisible(false);
        leftButton.setBounds(100, 300, 75, 110);
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setFocusPainted(false);
        leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                leftButton.setIcon(leftButtonEnteredImage);
                leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEntered.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                leftButton.setIcon(leftButtonBasicImage);
                leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("buttonPressed.mp3", false);
                buttonPressedMusic.start();
                //왼쪽버튼 이벤트
                selectLeft();
            }
        });

        add(leftButton);

        rightButton.setVisible(false);
        rightButton.setBounds(1100, 300, 75, 110);
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setFocusPainted(false);
        rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                rightButton.setIcon(rightButtonEnteredImage);
                rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEntered.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                rightButton.setIcon(rightButtonBasicImage);
                rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("buttonPressed.mp3", false);
                buttonPressedMusic.start();
                //오른쪽버튼 이벤트
                selectRight();
            }
        });

        add(rightButton);

        easyButton.setVisible(false);
        easyButton.setBounds(1100, 100, 200, 60);
        easyButton.setBorderPainted(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setFocusPainted(false);
        easyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                easyButton.setIcon(easyButtonEnteredImage);
                easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEntered.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                easyButton.setIcon(easyButtonBasicImage);
                easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("buttonPressed.mp3", false);
                buttonPressedMusic.start();
                //난이도 쉬움 이벤트
                gameStart(nowSelected, "Easy");
            }
        });

        add(easyButton);

        hardButton.setVisible(false);
        hardButton.setBounds(1100, 170, 200, 60);
        hardButton.setBorderPainted(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setFocusPainted(false);
        hardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hardButton.setIcon(hardButtonEnteredImage);
                hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEntered.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hardButton.setIcon(hardButtonBasicImage);
                hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("buttonPressed.mp3", false);
                buttonPressedMusic.start();
                //난이도 어려움 이벤트 
                gameStart(nowSelected, "Hard");
            }
        });

        add(hardButton);

        backButton.setVisible(false);
        backButton.setBounds(20, 50, 60, 60);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setIcon(backButtonEnteredImage);
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("buttonEntered.mp3", false);
                buttonEnteredMusic.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setIcon(backButtonBasicImage);
                backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("buttonPressed.mp3", false);
                buttonPressedMusic.start();
                //메인화면으로 돌아가는 이벤트
                backMain();
            }
        });

        add(backButton);

        menuBar.setBounds(0, 0, 1280, 30);

        //마우스로 메뉴바를 잡고 게임창을 이동시킨다.        
        menuBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        //마우스로 메뉴바를 잡고 게임창을 이동시킨다.
        menuBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });
        add(menuBar);
    }

    public void paint(Graphics g) {
        screenImage = createImage(Dynamic_beat_1.SCREEN_WIDTH, Dynamic_beat_1.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw((Graphics2D) screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics2D g) {
        g.drawImage(background, 0, 0, null);
        if (isMainScreen) {
//            
            g.drawImage(selectedImage, 400, 50, null);
            g.drawImage(titleImage, 340, 580, null);
        }

        if (isGameScreen) {
            game.screenDraw(g);
        }
        //JLabel 과같은 추가적인 image들을 자동으로 그려줌.
        paintComponents(g);
        try {
            Thread.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.repaint();
    }

    public void selectTrack(int nowSelected) {
        if (selectedMusic != null) {
            selectedMusic.close();
        }
        //nowSelected 의 index를 통해서 trackList에 있는 음악정보들을 가져온다.
        titleImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
        selectedImage = new ImageIcon(Dynamic_beat_1.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
        selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
        selectedMusic.start();
    }

    public void selectLeft() {
        if (nowSelected == 0) {
            nowSelected = trackList.size() - 1;
        } else {
            nowSelected--;
        }
        selectTrack(nowSelected);
    }

    public void selectRight() {
        if (nowSelected == trackList.size() - 1) {
            nowSelected = 0;
        } else {
            nowSelected++;
        }
        selectTrack(nowSelected);
    }

    public void gameStart(int nowSelected, String difficulty) {
        if (selectedMusic != null) {
            selectedMusic.close();
        }

        isMainScreen = false;
        leftButton.setVisible(false);
        rightButton.setVisible(false);
        easyButton.setVisible(false);
        hardButton.setVisible(false);
        background = new ImageIcon(Dynamic_beat_1.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
        backButton.setVisible(true);
        isGameScreen = true;

        game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
        game.start();
        setFocusable(true);
    }

    public void backMain() {
        isMainScreen = true;
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        background = new ImageIcon(Dynamic_beat_1.class.getResource("../images/mainBackground.png")).getImage();
        backButton.setVisible(false);
        selectTrack(nowSelected);
        isGameScreen = false;
        game.close();
    }

    public void enterMain() {
        startButton.setVisible(false);
        quitButton.setVisible(false);
        background = new ImageIcon(Dynamic_beat_1.class.getResource("../images/mainBackground.png")).getImage();
        isMainScreen = true;
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        introMusic.close();
        selectTrack(0);
    }
}
