#include <SDL2/SDL.h>

int main(int argc, char* argv[]) {
    // Inicialize o SDL
    if (SDL_Init(SDL_INIT_VIDEO) < 0) {
        printf("Erro ao inicializar o SDL: %s\n", SDL_GetError());
        return 1;
    }

    // Crie uma janela vazia
    SDL_Window* window = SDL_CreateWindow("Teste do SDL", SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, 640, 480, SDL_WINDOW_SHOWN);
    if (window == NULL) {
        printf("Erro ao criar a janela: %s\n", SDL_GetError());
        return 1;
    }

    // Mantenha a janela aberta por alguns segundos (ou até que seja fechada)
    SDL_Delay(5000);  // 5 segundos

    // Libere os recursos do SDL e finalize o SDL
    SDL_DestroyWindow(window);
    SDL_Quit();

    return 0;
}