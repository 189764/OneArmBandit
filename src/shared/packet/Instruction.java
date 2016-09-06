package shared.packet;

public enum Instruction {

  LOG_IN, LOG_OUT,
  REGISTER,
  REGISTER_SUCCES, REGISTER_ERROR,
  PLAY,
  SEND_RESULT, 
  LOG_IN_ERROR,
  CHANGE_PASSWORD,
  RESET_PASSWORD, CHANGE_PASSWORD_SUCCESS, 
  CHANGE_PASSWORD_ERROR, RESET_PASSWORD_ERROR, RESET_PASSWORD_SUCCESS, 
  LOG_IN_SUCCESS_USER, LOG_IN_SUCCESS_ADMIN,
  ASK_RANKING, SEND_RANKING, ASK_POINTS, SEND_POINTS,
  TRANSFER, SET_OF_SYMBOL_VALUES;
}