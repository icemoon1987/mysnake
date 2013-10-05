///////////////////////////////////////////////////////////
//  SnakeCore.h
//  Implementation of the Class SnakeCore
//  Created on:      05-Ê®ÔÂ-2013 11:16:09
//  Original author: icemoon
///////////////////////////////////////////////////////////

#if !defined(EA_9CEA4FEE_0B20_4b1f_9B43_CF089F565544__INCLUDED_)
#define EA_9CEA4FEE_0B20_4b1f_9B43_CF089F565544__INCLUDED_

#include "SnakeNode.h"
#include "SnakeDisplayAdapter.h"
#include "ConfigFileExtractor.h"
#include "SnakeControlAdapter.h"
#include "SnakeState.h"

class SnakeCore
{

public:
	SnakeCore();
	virtual ~SnakeCore();
	SnakeDisplayAdapter *m_SnakeDisplayAdapter;
	ConfigFileExtractor *m_ConfigFileExtractor;
	SnakeControlAdapter *m_SnakeControlAdapter;
	SnakeNode *m_SnakeNode;
	SnakeState *m_SnakeState;

	void GameInit();
	void SetDirection(const char dir);
	bool MoveSnake(const char dir);
	void GameCircle();
	void GameOver();

private:
	SnakeControlAdapter& m_ctrlAdapter;
	SnakeDisplayAdapter& m_dispAdapter;
	char m_dir;
	SnakeState* m_state;
	SnakeNode m_nodesvector;
	bool m_isPause;

};
#endif // !defined(EA_9CEA4FEE_0B20_4b1f_9B43_CF089F565544__INCLUDED_)
