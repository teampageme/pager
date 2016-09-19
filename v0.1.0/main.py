#Date modified 09_18_2016
from kivy.uix.gridlayout import GridLayout
from kivy.app import App



from kivy.lang import Builder

from kivy.app import App
from kivy.uix.image import Image
from kivy.uix.button import Button
from kivy.uix.widget import Widget
from kivy.uix.layout import Layout
from kivy.lang import Builder
from kivy.uix.gridlayout import GridLayout

Builder.load_file('trial.kv')

class mock_up_UI(GridLayout):
    pass

"""The class that loads the background image when the app opens. This was used earlier to create the mockup appearance, till we learnt how to use kivy to build UIs"""
class FullImage(Image):
    pass
	
#but = Button(text='send paging notifications!!', font_size=14, pos=(100, 100))
#but.add_widget()

"""The class which will run the app with PageMe().run(), which will include all the classes """
class PageMe(App):

#def image_display(self):
    #return FullImage(source='prototype.png', allow_stretch=True)

    def build(self):
        return mock_up_UI()


def main():
    PageMe().run()


main()

#source: We used a kivy tutorial to provide help in designing the UI with the buttons and our code structure is based 
